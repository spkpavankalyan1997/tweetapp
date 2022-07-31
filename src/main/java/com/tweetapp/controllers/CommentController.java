package com.tweetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.entities.Comment;
import com.tweetapp.services.CommentService;

@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/{tweetId}/comments")
	private List<Comment> getCommentsByTweetId(@PathVariable Long tweetId){
		return commentService.getAllByTweetId(tweetId);
	}
	
	@PostMapping("/{tweetId}/comment")
	private Long postComment(@RequestBody Comment comment) {
		return commentService.saveComment(comment);
	}

}
