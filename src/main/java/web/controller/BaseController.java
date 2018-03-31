package web.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import web.domain.BlockReload;
import web.domain.EditUserRequest;
import web.domain.LoginRequest;
import web.domain.RegisterRequest;
import web.entity.Sticker;
import web.entity.UserEntity;
import web.entity.enumeration.Country;
import web.mapper.StickerMapper;
import web.mapper.UserMapper;
import web.service.StickerService;
import web.service.UserService;
import web.service.utils.CustomFileUtils;

@Controller
public class BaseController {
	@Autowired StickerService stickerService;
	@Autowired private UserService userService;
	
	
	@GetMapping("asfasfasf/random")
		public String random() {
			
			for(int i = 0; i<40; i++) {
			Sticker sticker = new Sticker();
			sticker.setName("Name #"+1);
			
			stickerService.saveSticker(sticker);
			
		}
		
		return "";
	}
	
	
	
	@GetMapping({"/", "/home"})
	public String shoHome(Model model, @PageableDefault Pageable pageable) throws IOException {
//			for(int i = 0; i<40; i++) {
//				Sticker sticker = new Sticker();
//				sticker.setName("Name #"+1);
//				
//				stickerService.saveSticker(sticker);
//				
//			}
	//	Sticker stickerRandom = stickerService.random();
		
		Page<Sticker> page = stickerService.findAllStickerByPage(pageable);
		
		int currentPage = page.getNumber();
		int begin = Math.max(1, currentPage - 5);
		int end = Math.min(begin + 5, page.getNumber());
		
		
		
		
		
		
		List<Sticker> sticker = stickerService.findAllSticker();
		for(int i = 0; i < sticker.size(); i++) {
			String image = sticker.get(i).getStickerImage();
			sticker.get(i).setStickerImage(
					CustomFileUtils.getImage(
							"sticker_" + sticker.get(i).getId(), 
							image));
		}
		
		
		
		model.addAttribute("stickerList", sticker);
		model.addAttribute("stickersList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("stickerListByPageSize",page.getContent());
		
		
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
	
	@GetMapping("/admin")
		public String showAdmin(Model model) {
		model.addAttribute("findAllUsers", userService.findUserAll());
		return "admin";
	}
	
	@GetMapping("/admin/{userId}")
	public String changeBlock(@PathVariable("userId") int userId) {


//BlockReload request = UserMapper.getChangeBlock(entity);
//
// request.setBlock(true);
// 
//UserEntity user = UserMapper.setChangeBlock(request);
UserEntity user = userService.blockUser(userId);
		
	return "redirect:/admin";
}
}
