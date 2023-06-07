package com.mvidyn.std.phub.ui.repository;

import com.mvidyn.std.phub.ui.model.Access;
import com.mvidyn.std.phub.ui.model.Role;
import com.mvidyn.std.phub.ui.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
	public void Save_ReturnSavedUser() {
		// Act
		User savedUser = userRepository.save(userA);

		// Assert
		Assertions.assertThat(savedUser).isNotNull();
	}

	@Test
	public void FindAll_ReturnUsers() {
		// Arrange
		userRepository.save(userA);
		userRepository.save(userB);

		// Act
		Iterable<User> foundUsers = userRepository.findAll();

		// Assert
		Assertions.assertThat(foundUsers).isNotNull();
		Assertions.assertThat(foundUsers).hasSize(2);
	}
}