package com.tweetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweetapp.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>{

	List<Comment> findByTweetId(@Param("tweetId") Long tweetId);
}
