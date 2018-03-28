package web.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import web.domain.LoginRequest;
import web.domain.RegisterRequest;
import web.entity.Sticker;
import web.entity.enumeration.Country;
import web.mapper.UserMapper;
import web.service.StickerService;
import web.service.UserService;
import web.service.utils.CustomFileUtils;

@Controller
public class BaseController {
	@Autowired StickerService stickerService;
	@Autowired private UserService userService;
	
	@GetMapping({"/", "/home"})
	public String shoHome(Model model) throws IOException {
		List<Sticker> sticker = stickerService.findAllSticker();
		for(int i = 0; i < sticker.size(); i++) {
			String image = sticker.get(i).getStickerImage();
			sticker.get(i).setStickerImage(
					CustomFileUtils.getImage(
							"sticker_" + sticker.get(i).getId(), 
							image));
		}
		
		model.addAttribute("stickerList", sticker);
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("registerModel", new RegisterRequest());
		model.addAttribute("countries", Country.values());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String createUser(
			@ModelAttribute("registerModel") @Valid RegisterRequest registerRequest,
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		userService.saveUser(UserMapper.registerToUser(registerRequest));
		
		model.addAttribute("countries", Country.values());
		return "redirect:/login";
	}
		
}
