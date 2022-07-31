package com.tweetapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import com.tweetapp.entities.Comment;
import com.tweetapp.repositories.CommentRepository;

@ExtendWith(MockitoExtension.class)
public class TestCommentService {

	@Mock
	CommentRepository commentRepo;
	
	@BeforeTestMethod
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getAllByTweetIdTest() {

		int i = 1;
		List<Comment> list = commentRepo.findByTweetId(Long.valueOf(i));

		assertEquals(1, list.size());
	}
}
