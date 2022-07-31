package com.tweetapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.entities.Comment;
import com.tweetapp.repositories.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> getAllByTweetId(Long tweetId) {

		return commentRepository.findByTweetId(tweetId);
	}

	@Override
	public Long saveComment(Comment comment) {

		return commentRepository.save(comment).getId();
	}

}
