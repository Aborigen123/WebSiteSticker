package web.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;


import web.domain.BlockReload;
import web.domain.EditUserRequest;
import web.domain.LoginRequest;
import web.domain.RegisterRequest;
import web.domain.ShowSelect;
import web.domain.StickerNameFilter;
import web.entity.ActivityOrder;
import web.entity.Sticker;
import web.entity.StickerSafe;
import web.entity.UserEntity;
import web.entity.enumeration.Country;
import web.entity.enumeration.StickerType;
import web.mapper.ActivityOrderMapper;
import web.mapper.StickerMapper;
import web.mapper.StickerSafeMapper;
import web.mapper.UserMapper;
import web.repository.StickerRepository;
import web.service.ActivityOrderService;
import web.service.StickerSafeService;
import web.service.StickerService;
import web.service.UserService;
import web.service.utils.CustomFileUtils;

@Controller
public class BaseController {
	@Autowired StickerService stickerService;
	@Autowired private UserService userService;
	@Autowired ActivityOrderService activityOrderService;
	@Autowired StickerSafeService stickerSafeService;
	
	@ModelAttribute("stickerTypes")
    public StickerType[] stickerTypes()
    {
        return StickerType.values();
    }
	
	
	@GetMapping({"/", "/home"})
	public String shoHome(Model model, @PageableDefault Pageable pageable, @ModelAttribute("stickerTypes")StickerType stickerTypeModel) throws IOException {

		
		Page<Sticker> page = stickerService.findAllStickerByPage(pageable);
		
		int currentPage = page.getNumber();
		int begin = Math.max(1, currentPage - 5);
		int end = Math.min(begin + 5, page.getNumber());
		
		
		StickerType select;
		StickerType[] st;
		st = StickerType.values();

		
		
		List<Sticker> sticker = stickerService.findAllSticker();
		for(int i = 0; i < sticker.size(); i++) {
			String image = sticker.get(i).getStickerImage();
			sticker.get(i).setStickerImage(
					CustomFileUtils.getImage(
							"sticker_" + sticker.get(i).getId(), 
							image));
		}
		
		
		List<StickerType> stickerType = new ArrayList<>();
		
		
		
		
		model.addAttribute("select", StickerType.values());
		model.addAttribute("stickerList", sticker);
		model.addAttribute("stickersList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("stickerListByPageSize",page.getContent());
		
		
	return "home";
	}

//@PostMapping({"/", "/home"})
//	public String showHome(Model model) {
//			
//	model.addAttribute("stickerTypes1", StickerType.values());
//			return "redirect:/home";
//			}	
//			
	@GetMapping("/search")
	public String showSelect(Model model, @PageableDefault Pageable pageable, @RequestParam("search") String search) throws IOException {
		Page<Sticker> page = stickerService.findStickerByName(pageable, new StickerNameFilter(search));//search
		List<Sticker> sticker = stickerService.findAllSticker();
		for(int i = 0; i < sticker.size(); i++) {
			String image = sticker.get(i).getStickerImage();
			sticker.get(i).setStickerImage(
					CustomFileUtils.getImage(
							"sticker_" + sticker.get(i).getId(), 
							image));
		}
		model.addAttribute("stickerList", page.getContent());
		return "home";
	}
	
	@GetMapping("/select")
	public String showSelectDrop( Model model, @ModelAttribute("stickerTypes")StickerType stickerTypeModel) throws IOException {
		List<StickerType> stickerType = new ArrayList<>();
		StickerType select;
		StickerType[] st;
		st = StickerType.values();
		
		model.addAttribute("select", StickerType.values());
		
		return "home";
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

UserEntity user = userService.blockUser(userId);
		
	return "redirect:/admin";
}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/buy/{stickerId}")
	public String buy(Model model,@PathVariable("stickerId") int stickerId) {
		
		Sticker sticker = stickerService.findStickerById(stickerId);
		//UserEntity user = userService.findUserById(id);
		//ActivityOrder activityOrder = new ActivityOrder();
		
//		ActivityOrder activityOrder = new ActivityOrder();
//		activityOrder
		
		
		//activityOrderService.saveAddToActivity(new ActivityOrder(sticker.getName(),sticker.getPrice(), sticker.getUser().getFirstName(), activityOrder.getDate()));
		
		StickerSafe stickerSafe = StickerSafeMapper.stickerOnStickerSafe(sticker);
		
		stickerSafeService.saveStickerSafe(stickerSafe);
		
		
		ActivityOrder activityOrder = ActivityOrderMapper.stickerOnActivityOrder(sticker);
		
		activityOrderService.saveAddToActivity(activityOrder);
		
		stickerService.deleteByBuy(stickerId);

		    
		return "redirect:/";
	}
	

	
}
