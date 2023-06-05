package com.mvidyn.std.phub.ui.controller;

import java.util.List;

import com.mvidyn.std.phub.ui.model.User;
import com.mvidyn.std.phub.ui.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user, HttpSession session) {
		// @ResponseBody means the returned String is the response, not a view name
		User dbUser = userService.getUser(user);
		if (dbUser != null) {
			session.setAttribute("user", dbUser.getId());
			return new ResponseEntity<>(dbUser, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@PostMapping("/logout")
	public ResponseEntity<User> logout(HttpSession session) {
		session.removeAttribute("user");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<User> addNewUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	}

	@GetMapping(path = "/all")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(path = "/current")
	public String getCurrentUser(HttpSession session) {
		Object userId = session.getAttribute("user");
		if (userId != null) {
			User user = userService.getUserById((int) userId);
			return user.toString();
		}
		return "";
	}

}
