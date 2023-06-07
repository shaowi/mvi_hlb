package com.mvidyn.std.phub.ui.service.impl;

import java.util.List;

import com.mvidyn.std.phub.ui.model.User;
import com.mvidyn.std.phub.ui.repository.UserRepository;
import com.mvidyn.std.phub.ui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		if (isInvalidUser(user)) {
			throw new IllegalArgumentException("User is null");
		}
		if (isUserExists(user)) {
			throw new IllegalArgumentException("User already exists");
		}
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(User u1) {
		List<User> users = this.getAllUsers();
		return users.stream()
				.filter(u2 -> u1.getName().equals(u2.getName()) && u1.getPassword().equals(u2.getPassword()))
				.findFirst()
				.orElse(null);
	}

	@Override
	public User getUserById(int id) {
		List<User> users = this.getAllUsers();
		return users.stream()
				.filter(user -> user.getId() == id)
				.findFirst()
				.orElse(null);
	}

	private boolean isInvalidUser(User user) {
		return user == null || user.getName() == null;
	}

	private boolean isUserExists(User user) {
		List<User> users = this.getAllUsers();
		return users.stream()
				.anyMatch(u -> u.getName().equals(user.getName()));
	}

}
