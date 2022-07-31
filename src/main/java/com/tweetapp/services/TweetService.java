package com.tweetapp.services;

import java.util.List;

import com.tweetapp.entities.Tweet;

public interface TweetService {

	List<Tweet> getAllTweets();

	List<Tweet> getTweetsByUserId(Long userId);

	Long saveTweet(Tweet tweet);

	void updateTweet(Tweet tweet);

	void deleteTweet(Long tweetId);

	void likeTweet(Long tweetId);

	void dislikeTweet(Long tweetId);

	Tweet getTweetById(Long tweetId);

}
