package pl.coderslab.controllers;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repositories.TweetRepository;
import pl.coderslab.repositories.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	TweetRepository tweetRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	PasswordEncoder encoder;

	@RequestMapping("/register")
	private String userRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "user/register-form";
	}

	@PostMapping("/register")
	private String registerUser(@Valid User user, BindingResult results, Model model) {
		if (results.hasErrors()) {
			return "user/register-form";
		} else {
			model.addAttribute("user", user);
			try {
			userRepo.save(user);
			return "user/register-confirm";
			}
			catch(Exception e ) {
				model.addAttribute("error","Username or e-mail already taken");
				return "user/register-form";
			}
		}
	}

	@GetMapping(path = "/login")
	public String showLoginForm() {
		return "user/login-page";
	}

	@PostMapping(path = "/login")
	public String processLoginRequest(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model, HttpSession session) {
		User user = userRepo.findOneByUsername(username);

		if (user != null) {
			if (encoder.matches(password, user.getPassword())) {
				session.setAttribute("user", user);
				model.addAttribute("tweets", tweetRepo.findByUserId(user.getId()));
				model.addAttribute("tweet", new Tweet());
				return "user/user-home";
			}
			else {
				model.addAttribute("errorLogin","Password doesn't match");
			return "user/login-page";
			}
		} else {
			model.addAttribute("errorLogin","Invalid username");
			return "user/login-page";
		}
	}
	@RequestMapping("/home")
	private String userHome(@SessionAttribute(name="user",required=false)User user,Model model) {
		if(user!=null) {
		model.addAttribute("user",user);
		model.addAttribute("tweet", new Tweet());
		model.addAttribute("tweets", tweetRepo.findByUserId(user.getId()));
		model.addAttribute("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd HH-mm"));
		return "user/user-home";
		}
		else {
			return"redirect:/user/login";
		}
	}
	@RequestMapping("/delete")
	private String deleteAccount(@SessionAttribute(name="user",required=false)User user,Model model) {
		if(user!=null) {
			userRepo.delete(user);
		}
		return"redirect:/";
	}
}
