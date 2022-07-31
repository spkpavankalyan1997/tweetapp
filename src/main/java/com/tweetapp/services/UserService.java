package com.tweetapp.services;

import java.util.List;

import com.tweetapp.entities.User;

public interface UserService {

	List<User> getAllUsers();

	Long saveUser(User user);

	User getUser(Long id);

}
