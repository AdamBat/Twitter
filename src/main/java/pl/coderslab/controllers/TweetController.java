package pl.coderslab.controllers;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repositories.CommentRepository;
import pl.coderslab.repositories.TweetRepository;
import pl.coderslab.repositories.UserRepository;

@Controller
@RequestMapping("/tweet")
public class TweetController {
	@Autowired
	TweetRepository tweetRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	CommentRepository commentRepo;
	@ModelAttribute("tweets")
	private List <Tweet> getAllTweets(){
		return tweetRepo.findAll();
	}
	
	@ModelAttribute("users")
	public Collection<User> getUsers(){
		return userRepo.findAll();
	}
	@RequestMapping("/add")
	private String addTweet(Model model) {
		model.addAttribute("tweet", new Tweet());
		return "tweet-form";
	}
	
	@PostMapping("/add")
	private String confirmTweet(@Valid Tweet tweet,BindingResult result,@SessionAttribute(name="user",required=false) User user,HttpSession session) {
		
		tweet.setUser(user);
		if(result.hasErrors()) {
			session.setAttribute("user", user);
			return "redirect:/user/home";
		}
		else {
		tweetRepo.save(tweet);
		return "redirect:/user/home";
		}
	}
	
	@GetMapping("/all")
	private String getAllTweets(@SessionAttribute(name="user",required=false)User user,Model model) {
		if(user!=null) {
			model.addAttribute("tweets", tweetRepo.findByUserId(user.getId()));
			return "all-tweets";
		}
		else {
			return "redirect:/index.jsp";
		}
	}
	@GetMapping("/comments/{id}")
	private String showComments(@PathVariable long id,Model model) {
		Comment comment = new Comment();
		System.out.println(comment.toString());
		Tweet tweet = tweetRepo.getOne(id);
		List<Comment> comments = (List<Comment>)commentRepo.findAllByTweet(tweet);
		model.addAttribute("comment",comment);
		model.addAttribute("comments",comments);
		model.addAttribute("tweet", tweet);
		return "show-comments";
		
	}
}
