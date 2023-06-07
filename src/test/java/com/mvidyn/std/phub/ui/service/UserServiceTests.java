package com.mvidyn.std.phub.ui.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.mvidyn.std.phub.ui.model.Access;
import com.mvidyn.std.phub.ui.model.Role;
import com.mvidyn.std.phub.ui.model.User;
import com.mvidyn.std.phub.ui.repository.UserRepository;
import com.mvidyn.std.phub.ui.service.impl.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceImpl userService;

	private User userA;
	private User userB;

	@BeforeEach
	public void setup() {
		userA = User.builder()
				.id(0)
				.name("maker")
				.password("pw")
				.access(Access.ADMIN)
				.role(Role.MAKER)
				.build();
		userB = User.builder()
				.id(1)
				.name("checker")
				.password("pw")
				.access(Access.ADMIN)
				.role(Role.CHECKER)
				.build();
	}

	@Test
	public void SaveUser_ReturnUser() {
		// Arrange
		when(userRepository.save(userA)).thenReturn(userA);

		// Act
		User savedUser = userService.saveUser(userA);

		// Assert
		Assertions.assertThat(savedUser).isNotNull();
	}

	@Test
	public void SaveNullUser_ThrowIllegalArgException() {
		assertThrows(IllegalArgumentException.class, () -> userService.saveUser(null));
	}

	@Test
	public void SaveInvalidUser_ThrowIllegalArgException() {
		User invalidUser = User.builder()
				.password("pw")
				.access(Access.ADMIN)
				.role(Role.MAKER)
				.build();

		// Assert
		assertThrows(IllegalArgumentException.class, () -> userService.saveUser(invalidUser));
	}

	@Test
	public void GetAllUsers_ReturnUsers() {
		// Arrange
		when(userRepository.findAll()).thenReturn(Arrays.asList(userA, userB));

		// Act
		List<User> foundUsers = userService.getAllUsers();

		// Assert
		Assertions.assertThat(foundUsers).isNotNull();
		Assertions.assertThat(foundUsers).size().isEqualTo(2);
	}

	@Test
	public void GetUser_ReturnUser() {
		// Arrange
		userRepository.save(userA);
		userRepository.save(userB);
		when(userRepository.findAll()).thenReturn(Arrays.asList(userA, userB));

		// Act
		User foundUser = userService.getUser(userA);

		// Assert
		Assertions.assertThat(foundUser).isNotNull();
		Assertions.assertThat(foundUser).isEqualTo(userA);
	}

	@Test
	public void GetUserById_ReturnUser() {
		userRepository.save(userA);
		userRepository.save(userB);
		when(userRepository.findAll()).thenReturn(Arrays.asList(userA, userB));

		// Act
		User foundUser = userService.getUserById(userB.getId());

		// Assert
		Assertions.assertThat(foundUser).isNotNull();
		Assertions.assertThat(foundUser).isEqualTo(userB);
	}
}
