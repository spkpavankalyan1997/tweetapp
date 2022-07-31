package com.tweetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.entities.Tweet;
import com.tweetapp.services.TweetService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0/tweets")
public class TweetController {

	@Autowired
	private TweetService tweetService;

	@GetMapping("/all")
	private List<Tweet> getAllTweets() {
		return tweetService.getAllTweets();
	}

	@GetMapping("/{userId}")
	private List<Tweet> getTweetsByUserId(@PathVariable Long userId) {
		return tweetService.getTweetsByUserId(userId);
	}

	@PostMapping("/add")
	private Long postTweet(@RequestBody Tweet tweet) {
		return tweetService.saveTweet(tweet);
	}

	@DeleteMapping("/delete/{tweetId}")
	private void deleteTweet(@PathVariable Long tweetId) {
		tweetService.deleteTweet(tweetId);
	}

	@PutMapping("/update")
	private void updateTweet(@RequestBody Tweet tweet) {
		tweetService.updateTweet(tweet);
	}

	@PutMapping("/like/{tweetId}")
	private void likeTweet(@PathVariable Long tweetId) {
		tweetService.likeTweet(tweetId);
	}

	@PutMapping("/dislike/{tweetId}")
	private void dislikeTweet(@PathVariable Long tweetId) {
		tweetService.dislikeTweet(tweetId);
	}

	@GetMapping("/tweet/{tweetId}")
	private Tweet getTweetById(@PathVariable Long tweetId) {
		return tweetService.getTweetById(tweetId);
	}
}
