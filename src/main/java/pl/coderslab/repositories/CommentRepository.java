package pl.coderslab.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
@Component
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	Collection<Comment> findAllByTweet(Tweet tweet);
	Collection<Comment> findAllByTweetId(long id);
	Collection<Comment> findAllByOrderByCreated();
}
