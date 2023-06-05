package com.mvidyn.std.phub.ui.controller;

import java.util.List;

import com.mvidyn.std.phub.ui.model.User;
import com.mvidyn.std.phub.ui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String login() {
		return "login";
	}

	@PostMapping("/logout")
	public String loginPost() {
		return "loginPost";
	}

	@PostMapping("/signup")
	public @ResponseBody String addNewUser(@RequestBody User user) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		userService.saveUser(user);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
