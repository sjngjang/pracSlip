package net.sj.slipp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("")
	public String showHome() {
		logger.debug("Go to Home");
		return "index";
	} 
}
