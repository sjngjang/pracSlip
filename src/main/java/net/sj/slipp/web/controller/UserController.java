package net.sj.slipp.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.sj.slipp.web.domain.User;
import net.sj.slipp.web.service.UserService;

@Controller
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	UserService userService;
	
	@GetMapping("/index")
	public String showHome() {
		logger.debug("Go to Home");
		return "index";
	} 
	
	@GetMapping("/user/form")
	public String showSinginForm() {
		logger.debug("Go to login page");
		return "/user/form";
	} 
	
	@GetMapping("/user/login")
	public String showLoginForm() {
		logger.debug("Go to login page");
		return "/user/login";
	} 
	
	
	@PostMapping("/signin")
	public String addUser(User newUser) {
		logger.debug("Go to sign-in form");
		logger.debug("Sended user info {}", newUser);
		
		userService.addNewUser(newUser);
		return "redirect:/user/list";
	} 
	
	@GetMapping("/user/list")
	public String showUserList(Model model){
		logger.debug("Show user list");
		List<User> users=userService.findAll();
		
		logger.debug("Rendering user list page");
		model.addAttribute("users", users);
		return "/user/list";
	}
	
}
