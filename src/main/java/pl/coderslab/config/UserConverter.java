package pl.coderslab.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.entity.User;
import pl.coderslab.repositories.UserRepository;
public class UserConverter implements Converter<String,User>{


@Autowired
UserRepository userRepo;

	@Override
	public User convert(String source) {

		User user = userRepo.getOne(Long.parseLong(source));
		return user;
	}

}

