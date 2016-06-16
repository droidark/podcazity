package net.virux.podcazity.service;

import java.util.List;

import net.virux.podcazity.model.User;

public interface UserService {

	void addUser(User user);
	
	List<User> getAllUsers();
	
	User getUser(int id);
	
	User getUser(String username);
	
	void setUser(User user);
	
	void deleteUser(User user);
}
