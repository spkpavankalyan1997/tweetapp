package com.tweetapp.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long tweetId;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	@Size(max = 144)
	private String replyMessage;

	@Column(nullable = false)
	private LocalDateTime replyTime;

	
	public Comment(Long id, Long tweetId, String userName, @Size(max = 144) String replyMessage,
			LocalDateTime replyTime) {
		super();
		this.id = id;
		this.tweetId = tweetId;
		this.userName = userName;
		this.replyMessage = replyMessage;
		this.replyTime = replyTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}

	public LocalDateTime getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(LocalDateTime replyTime) {
		this.replyTime = replyTime;
	}

}
