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
	public void UserRepository_Save_ReturnSavedUser() {

		// Arrange
		User user = User.builder()
				.name("name")
				.password("pw").build();

		// Act
		User savedUser = userRepository.save(user);

		// Assert
		Assertions.assertThat(savedUser).isNotNull();
	}
}