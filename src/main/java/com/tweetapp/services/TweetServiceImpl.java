package com.tweetapp.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.entities.Comment;
import com.tweetapp.entities.Tweet;
import com.tweetapp.repositories.CommentRepository;
import com.tweetapp.repositories.TweetRepository;

@Service
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Tweet> getAllTweets() {

		return tweetRepository.findAll();
	}

	@Override
	public List<Tweet> getTweetsByUserId(Long userId) {

		return tweetRepository.findByUserId(userId);
	}

	@Override
	public Long saveTweet(Tweet tweet) {

		return tweetRepository.save(tweet).getId();
	}

	@Override
	public void updateTweet(Tweet tweet) {

		Optional<Tweet> t = tweetRepository.findById(tweet.getId());
		if (t.isPresent()) {
			tweetRepository.save(tweet);
		}
	}

	@Override
	public void deleteTweet(Long tweetId) {

		tweetRepository.deleteById(tweetId);
	}

	@Override
	@Transactional
	public void likeTweet(Long tweetId) {
		tweetRepository.updateLikes(tweetId);

	}

	@Override
	@Transactional
	public void dislikeTweet(Long tweetId) {
		tweetRepository.updatedislikes(tweetId);

	}

	@Override
	@Transactional
	public Tweet getTweetById(Long tweetId) {
		Tweet tweetInfo = tweetRepository.findById(tweetId).get();
		List<Comment> tweetComments = commentRepository.findByTweetId(tweetId);
		tweetInfo.setComments(tweetComments);
		return tweetInfo;
	}

}
