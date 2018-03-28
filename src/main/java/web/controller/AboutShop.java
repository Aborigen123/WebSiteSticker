package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/aboutshop")
public class AboutShop {
	
	@GetMapping("/ourcontacts")
	public String showOurContacts() {
		
		return "aboutshop/ourcontacts";
	}
	
	
	@GetMapping("/aboutus")
	public String showAboutUs() {
		
		return "aboutshop/aboutus";
	}

}
