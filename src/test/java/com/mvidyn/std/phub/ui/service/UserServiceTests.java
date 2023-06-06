package com.mvidyn.std.phub.ui.service;

import static org.mockito.Mockito.when;

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
	public void CreateUser_ReturnUser() {
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
}
