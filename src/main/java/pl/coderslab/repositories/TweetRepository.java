package pl.coderslab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Tweet;
@Component
public interface TweetRepository extends JpaRepository<Tweet, Long> {
	List<Tweet> findByUserId(long id);
	@Query("select t from Tweet t where t.title like ?1% order by created")
	List<Tweet> findAllLike(String text);
}
