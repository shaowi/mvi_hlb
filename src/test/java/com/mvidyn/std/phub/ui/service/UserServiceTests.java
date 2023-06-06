package com.mvidyn.std.phub.ui.service;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.mvidyn.std.phub.ui.model.User;
import com.mvidyn.std.phub.ui.repository.UserRepository;
import com.mvidyn.std.phub.ui.service.impl.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
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

	@Test
	public void SaveUser_ReturnUser() {
		// Arrange
		User user = User.builder()
				.name("name")
				.password("pw").build();

		when(userRepository.save(user)).thenReturn(user);

		// Act
		User savedUser = userService.saveUser(user);

		// Assert
		Assertions.assertThat(savedUser).isNotNull();
	}

	@Test
	public void GetAllUsers_ReturnUsers() {
		// Arrange
		User user = User.builder()
				.name("name")
				.password("pw").build();
		User user2 = User.builder()
				.name("name2")
				.password("pw2").build();
		userRepository.save(user);
		userRepository.save(user2);
		when(userRepository.findAll()).thenReturn(Arrays.asList(user, user2));

		// Act
		List<User> foundUsers = userService.getAllUsers();

		// Assert
		Assertions.assertThat(foundUsers).isNotNull();
		Assertions.assertThat(foundUsers).size().isEqualTo(2);
	}

	@Test
	public void GetUser_ReturnUser() {
		// Arrange
		User user = User.builder()
				.name("name")
				.password("pw").build();
		User user2 = User.builder()
				.name("name2")
				.password("pw2").build();
		userRepository.save(user);
		userRepository.save(user2);
		when(userRepository.findAll()).thenReturn(Arrays.asList(user, user2));

		// Act
		User foundUser = userService.getUser(user);

		// Assert
		Assertions.assertThat(foundUser).isNotNull();
		Assertions.assertThat(foundUser).isEqualTo(user);
	}

	@Test
	public void GetUserById_ReturnUser() {
		// Arrange
		User user = User.builder()
				.id(0)
				.name("name")
				.password("pw").build();
		User user2 = User.builder()
				.id(1)
				.name("name2")
				.password("pw2").build();
		userRepository.save(user);
		userRepository.save(user2);
		when(userRepository.findAll()).thenReturn(Arrays.asList(user, user2));

		// Act
		User foundUser = userService.getUserById(user2.getId());

		// Assert
		Assertions.assertThat(foundUser).isNotNull();
		Assertions.assertThat(foundUser).isEqualTo(user2);
	}
}
