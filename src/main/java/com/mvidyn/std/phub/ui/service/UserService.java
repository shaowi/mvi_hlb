package com.mvidyn.std.phub.ui.service;

import java.util.List;

import com.mvidyn.std.phub.ui.model.User;
import com.mvidyn.std.phub.ui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUser(User u1) {
		return this.getAllUsers().stream()
				.filter(u2 -> u1.getName().equals(u2.getName()) && u1.getPassword().equals(u2.getPassword()))
				.findFirst()
				.orElse(null);
	}

	public User getUserById(int id) {
		return this.getAllUsers().stream()
				.filter(user -> user.getId() == id)
				.findFirst()
				.orElse(null);
	}

}
