package net.sj.slipp.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sj.slipp.web.domain.User;
import net.sj.slipp.web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	UserService userService;
	
	@GetMapping("/form")
	public String showSigninForm() {
		logger.debug("Go to login page");
		return "/user/form";
	} 
	
	@GetMapping("/login")
	public String showLoginForm() {
		logger.debug("Go to login page");
		return "/user/login";
	} 
	
	@PostMapping("")
	public String addUser(User newUser) {
		logger.debug("Go to sign-in form");
		logger.debug("Sended user info {}", newUser);
		
		userService.addNewUser(newUser);
		return "redirect:/users";
	} 
	
	@GetMapping("")
	public String showUserList(Model model){
		logger.debug("Show user list");
		List<User> users=userService.findAll();
		
		logger.debug("Rendering user list page");
		model.addAttribute("users", users);
		return "/user/list";
	}
	
	@GetMapping("/{id}/form")
	public String updateUserForm(@PathVariable Long id, Model model){
		logger.debug("Show user information update form");
		User user = userService.findById(id);
		model.addAttribute("user",user);
		
		return "/user/updateForm";
	}
	
	@PutMapping("/{id}/update")
	public String updateUser(@PathVariable Long id, User updatedUser) {
		logger.debug("update user information");
		
		userService.updateById(id, updatedUser);
		
		logger.debug("user is updated");
		
		return "redirect:/users";
	}
}
