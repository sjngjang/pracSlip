package net.sj.slipp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/helloworld")
	public String welcome(String name, Long age, Model model){
		logger.debug("name and age : ", name, age);
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "welcome"; // 파일 이름
	}
}
