package pl.coderslab.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;

public interface MessageRepository extends JpaRepository<Message, Long> {
	Collection<Message> findAllByRecipient(User user);
	Collection<Message> findAllBySender(User user);
}
