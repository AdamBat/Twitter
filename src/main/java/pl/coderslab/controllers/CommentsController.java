package pl.coderslab.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import pl.coderslab.entity.Comment;
import pl.coderslab.entity.User;
import pl.coderslab.repositories.CommentRepository;
import pl.coderslab.repositories.TweetRepository;

@RequestMapping("/comments")
@Controller
public class CommentsController {
	@Autowired
	TweetRepository tweetRepo;
	@Autowired
	CommentRepository commentRepo;

	@RequestMapping("/add/{id}")
	private String addComment(@SessionAttribute(name = "user", required = false) User user, @PathVariable long id,
			@Valid @ModelAttribute Comment comment, BindingResult result, Model model) {
		if(user!=null) {
			Comment comm = new Comment(user,tweetRepo.getOne(id),comment.getText());
	/*	comment.setTweet(tweetRepo.getOne(id));
		comment.setUser(user);*/
		commentRepo.save(comm);
		model.addAttribute("comment", "Comment has been added");
		return "redirect:/user/home";
		}
		else {
			System.out.println("user to null");
			model.addAttribute("comment", "Comment has NOT been added");

			return "redirect:/user/home";
		}

	}
}
