package com.mvidyn.std.phub.ui.controller;

import java.util.List;

import com.mvidyn.std.phub.ui.model.User;
import com.mvidyn.std.phub.ui.service.UserService;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user, HttpSession session) {
		User dbUser = userService.getUser(user);
		if (dbUser != null) {
			session.setAttribute("user", dbUser.getId());
			LOGGER.info("User " + dbUser.getName() + " logged in");
			return new ResponseEntity<>(dbUser, HttpStatus.OK);
		}
		LOGGER.error("User failed to login");
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/logout")
	public ResponseEntity<User> logout(HttpSession session) {
		session.removeAttribute("user");
		LOGGER.info("User logged out");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<User> addNewUser(@RequestBody User user) {
		try {
			LOGGER.info("User " + user.getName() + " signed up");
			return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path = "/all")
	public ResponseEntity<List<User>> getAllUsers() {
		LOGGER.info("Get all users");
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping(path = "/current")
	public ResponseEntity<User> getCurrentUser(HttpSession session) {
		Object userId = session.getAttribute("user");
		if (userId != null) {
			User user = userService.getUserById((int) userId);
			LOGGER.info("Get current user " + user.getName());
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		LOGGER.info("No user logged in");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
