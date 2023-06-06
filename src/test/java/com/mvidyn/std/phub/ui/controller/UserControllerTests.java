package com.mvidyn.std.phub.ui.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvidyn.std.phub.ui.model.User;
import com.mvidyn.std.phub.ui.service.UserService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

	private static final String BASE = "/user";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Autowired
	private ObjectMapper objectMapper;

	private User user;

	@BeforeEach
	public void setup() {
		user = User.builder().name("name").password("pw").build();
	}

	@Test
	public void shouldCreateAttributes() {
		assertNotNull(mockMvc);
		assertNotNull(userService);
		assertNotNull(objectMapper);
		assertNotNull(user);
	}

	@Test
	public void SignupUser_ReturnCreated() throws Exception {
		// Arrange
		given(userService.saveUser(ArgumentMatchers.any())).willAnswer((invocation) -> invocation.getArgument(0));
		String endpoint = BASE + "/signup";

		// Act
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post(endpoint)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user)));

		// Assert
		response.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(user.getName())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.password", CoreMatchers.is(user.getPassword())));
	}

	@Test
	public void LoginExistingUser_ReturnOk() throws Exception {
		// Arrange
		when(userService.getUser(user)).thenReturn(user);
		String endpoint = BASE + "/login";

		// Act
		ResultActions response =
		mockMvc.perform(MockMvcRequestBuilders.post(endpoint)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user)));

		// Assert
		response.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(user.getName()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.password").value(user.getPassword()));
	}

	@Test
	public void LoginNonExistingUser_ReturnUnauthorised() throws Exception {
		// Arrange
		User newUser = User.builder().name("newName").password("newPw").build();
		when(userService.getUser(newUser)).thenReturn(null);
		String endpoint = BASE + "/login";

		// Act
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post(endpoint)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(user)));

		// Assert
		response.andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}

	@Test
	public void LogoutUser_ReturnOk() throws Exception {
		// Arrange
		String endpoint = BASE + "/logout";

		// Act
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post(endpoint));

		// Assert
		response.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void GetAllUser_ReturnsOk() throws Exception {
		// Arrange
		String endpoint = BASE + "/all";

		// Act
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(endpoint));

		// Assert
		response.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void GetCurrentUser_ReturnsUser() throws Exception {
		// Arrange
		String endpoint = BASE + "/current";
		MockHttpSession session = new MockHttpSession();

		// Sign up user and set session
		userService.saveUser(user);
		session.setAttribute("user", user.getId());

		// Act
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(endpoint).session(session));

		// Assert
		response.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void GetCurrentUser_ReturnsNotFound() throws Exception {
		// Arrange
		String endpoint = BASE + "/current";
		MockHttpSession session = new MockHttpSession();

		// Act
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get(endpoint).session(session));

		// Assert
		response.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
