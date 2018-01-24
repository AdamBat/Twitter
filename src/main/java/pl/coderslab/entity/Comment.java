package pl.coderslab.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private User user;
	@ManyToOne
	@JoinColumn(name="tweet_id")
	private Tweet tweet;
	@CreationTimestamp
	private LocalDateTime created;
	private String text;
	
	
	public Comment() {
	}
	public Comment(User user, Tweet tweet, String text) {
		this.user = user;
		this.tweet = tweet;
		this.text = text;
	}
	public Comment(User user, Tweet tweet, LocalDateTime created, String text) {
		this.user = user;
		this.tweet = tweet;
		this.created = created;
		this.text = text;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Tweet getTweet() {
		return tweet;
	}
	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}
	public LocalDateTime getCreated() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		return LocalDateTime.parse(this.created.toString().substring(0, 16),formatter);
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", tweet=" + tweet + ", created=" + created + ", text=" + text
				+ "]";
	}
	
	
	
	
}
