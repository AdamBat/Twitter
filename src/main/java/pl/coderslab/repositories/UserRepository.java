package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import pl.coderslab.entity.User;
@Component
public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByUsername(String username);

}
