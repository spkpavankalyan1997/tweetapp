package com.tweetapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweetapp.entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	List<Tweet> findByUserId(@Param("userId") Long userId);

	@Modifying
	@Query("update Tweet t set t.likes=t.likes+1 where t.id=:tweetId")
	void updateLikes(@Param("tweetId") Long tweetId);
	
	@Modifying
	@Query("update Tweet t set t.dislikes=t.dislikes+1 where t.id=:tweetId")
	void updatedislikes(@Param("tweetId") Long tweetId);

}
