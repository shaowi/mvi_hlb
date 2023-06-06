package com.mvidyn.std.phub.ui.service;

import java.util.List;

import com.mvidyn.std.phub.ui.model.User;

public interface UserService {
	public User saveUser(User user);

	public List<User> getAllUsers();

	public User getUser(User u1);

	public User getUserById(int id);
}
