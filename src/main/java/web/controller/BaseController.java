package web.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import web.domain.BlockReload;
import web.domain.EditUserRequest;
import web.domain.LoginRequest;
import web.domain.RegisterRequest;
import web.domain.ShowSelect;
import web.domain.StickerNameFilter;
import web.entity.ActivityOrder;
import web.entity.HistorySell;
import web.entity.Sticker;
import web.entity.StickerSafe;
import web.entity.UserEntity;
import web.entity.enumeration.Country;
import web.entity.enumeration.StickerType;
import web.mapper.ActivityOrderMapper;
import web.mapper.HistorySellMapper;
import web.mapper.StickerMapper;
import web.mapper.StickerSafeMapper;
import web.mapper.UserMapper;
import web.repository.StickerRepository;
import web.service.ActivityOrderService;
import web.service.HistorySellService;
import web.service.StickerSafeService;
import web.service.StickerService;
import web.service.UserService;
import web.service.utils.CustomFileUtils;

@Controller
@SessionAttributes("countries, stickerType")
public class BaseController {
	@Autowired StickerService stickerService;
	@Autowired private UserService userService;
	@Autowired ActivityOrderService activityOrderService;
	@Autowired StickerSafeService stickerSafeService;
	@Autowired HistorySellService historySellService;
	
	@ModelAttribute("stickerTypes")
    public List<StickerType> stickerTypes()
    {
        return Arrays.asList(StickerType.values());
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
		
		
		//List<StickerType> stickerType = new ArrayList<>();
		
		
		List<String> stickerTypes = Stream.of(StickerType.values()).map(StickerType::name).collect(Collectors.toList());
		   
		model.addAttribute("stickerType", stickerTypes);
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
	public String showSelectDrop( Model model, @ModelAttribute("stickerTypes")String stickerTypeModel) throws IOException {
		List<StickerType> stickerType = new ArrayList<>();
		StickerType select;
		StickerType[] st;
		st = StickerType.values();
		
		model.addAttribute("select", stickerTypeModel);
		
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
	
	@GetMapping("/adminun/{userId}")
	public String unchangeBlock(@PathVariable("userId") int userId) {


UserEntity user = userService.unblockUser(userId);
		
	return "redirect:/admin";
}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("loginModel", new LoginRequest());
		return "login";
	}
	
	@GetMapping("/buy/{stickerId}")
	public String buy(Model model,@PathVariable("stickerId") int stickerId, Principal principal) {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		Sticker sticker1 = stickerService.findStickerById(stickerId);
		
		if(entity.getBlock() == true) {
			return "redirect:/block";
		}else if (sticker1.getBought() == true) {
			return "redirect:/stickeralreadybuy";}else {
		Sticker sticker = stickerService.findStickerById(stickerId);
		sticker.setBought(true);
		StickerSafe stickerSafe = StickerSafeMapper.stickerOnStickerSafe(sticker);
		stickerSafeService.saveStickerSafe(stickerSafe);
		
		
		ActivityOrder activityOrder = ActivityOrderMapper.stickerOnActivityOrder(sticker);
		activityOrder.setUserCustomer(principal.getName());
		activityOrderService.saveAddToActivity(activityOrder);
			}
		return "redirect:/";
	}
	
@GetMapping("/block")
public String block() {
	
	return"block";
}

@GetMapping("/stickeralreadybuy")
public String stickeralreadybuy() {
	
	return"stickeralreadybuy";
}
@GetMapping("/nowbuy/{stickerId}")
public String nowbuy(Model model,@PathVariable("stickerId") int stickerId, Principal principal) {
	UserEntity entity = userService.findUserByEmail(principal.getName());
	Sticker sticker1 = stickerService.findStickerById(stickerId);
	
	if(entity.getBlock() == true) {
		return "redirect:/block";
	}else if (sticker1.getBought() == true) {
		return "redirect:/stickeralreadybuy";}else {

		Sticker sticker = stickerService.findStickerById(stickerId);
		String userGet = principal.getName();
		HistorySell hs = historySellService.findParticularUserHistoryBuy(userGet);
		
		HistorySell historySell = HistorySellMapper.nowBuy(sticker);
		historySell.setUserBuy(principal.getName());
		historySellService.saveHistorySell(historySell);
		
		model.addAttribute("findParticularHistory", hs);
		
		stickerService.deleteByBuy(stickerId);
	}
	return "redirect:/";
}
}
