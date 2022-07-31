package com.tweetapp.services;

import java.util.List;

import com.tweetapp.entities.Comment;

public interface CommentService {
	
	List<Comment> getAllByTweetId(Long tweetId);
	
	Long saveComment(Comment comment);

}
