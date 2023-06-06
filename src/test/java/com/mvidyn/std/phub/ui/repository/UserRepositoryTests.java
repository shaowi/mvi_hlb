package com.mvidyn.std.phub.ui.repository;

import com.mvidyn.std.phub.ui.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void Save_ReturnSavedUser() {
		// Arrange
		User user = User.builder()
				.name("name")
				.password("pw").build();

		// Act
		User savedUser = userRepository.save(user);

		// Assert
		Assertions.assertThat(savedUser).isNotNull();
		Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
	}

	@Test
	public void FindAll_ReturnUsers() {
		// Arrange
		User user = User.builder()
				.name("name")
				.password("pw").build();
		User user2 = User.builder()
				.name("name2")
				.password("pw2").build();
		userRepository.save(user);
		userRepository.save(user2);

		// Act
		Iterable<User> foundUsers = userRepository.findAll();

		// Assert
		Assertions.assertThat(foundUsers).isNotNull();
		Assertions.assertThat(foundUsers).hasSize(2);
	}
}