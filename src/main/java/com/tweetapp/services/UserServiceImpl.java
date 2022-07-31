package com.tweetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.entities.User;
import com.tweetapp.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Long saveUser(User user) {
		return userRepository.save(user).getId();
	}

	public User getUser(Long id) {
		Optional<User> usr = userRepository.findById(id);
		return usr.get();
	}

}
