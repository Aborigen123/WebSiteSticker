package web.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import web.domain.CreateAdvRequest;
import web.domain.EditUserRequest;
import web.domain.UserProfileRequest;
import web.entity.ActivityOrder;
import web.entity.HistorySell;
import web.entity.Sticker;
import web.entity.StickerSafe;
import web.entity.UserEntity;
import web.entity.enumeration.AboutSticker;
import web.entity.enumeration.StickerType;
import web.mapper.HistorySellMapper;
import web.mapper.StickerMapper;
import web.mapper.StickerSafeMapper;
import web.mapper.UserMapper;
import web.service.ActivityOrderService;
import web.service.HistorySellService;
import web.service.StickerSafeService;
import web.service.StickerService;
import web.service.UserService;
import web.service.utils.CustomFileUtils;

@Controller
@RequestMapping("/user")
@SessionAttributes("editModel")
public class UserController {

	@Autowired UserService userService;
	@Autowired StickerService stickerService;
	@Autowired ActivityOrderService activityOrderService;
	@Autowired HistorySellService historySellService;
	@Autowired StickerSafeService stickerSafeService;
	
	@GetMapping
	public String showUserProfile(Model model, Principal principal) throws IOException {
		System.out.println("Secured user name: " + principal.getName());
		UserEntity entity = userService.findUserByEmail(principal.getName());	
		
		if(entity == null) return "redirect:/";
		
		ActivityOrder activityOrder = new ActivityOrder();
	//	activityOrderService.selectActivetyOrderByParticularUser(principal.getName());
		
		
/*Page<ActivityOrder> page = activityOrderService.findAllActivityOrder();*/
		

		
//		List<ActivityOrder> acTionOrd = activityOrderService.findAllActivityOrder();
//		for(int i = 0; i < acTionOrd.size(); i++) {
//			String image = acTionOrd.get(i).getStickerImage();
//			acTionOrd.get(i).setStickerImage(
//					CustomFileUtils.getImage(
//							"acTionOrdder_" + acTionOrd.get(i).getId(), 
//							image));
//		}
		
		
		UserProfileRequest request = UserMapper.entityToUserProfile(entity);
		
		model.addAttribute("userProfile", request);
		model.addAttribute("imageSrc",
				CustomFileUtils.getImage("user_" + entity.getId(), entity.getImagePath()));
		String userGet = principal.getName();
	ActivityOrder ao = activityOrderService.selectActivetyOrderByParticularUser(userGet);
	//	model.addAttribute("findAllActivityOrder", activityOrderService.findAllActivityOrder());
		model.addAttribute("findAllActivityOrder", 	ao);
		model.addAttribute("imageActivityOrder",CustomFileUtils.getImage("activityOrder_" + activityOrder.getId(), activityOrder.getStickerImage()));
		return "user/profile";
	}
	
	@GetMapping("/finalyBuy/{activityOrderId}")
	public String finalyBuy(@PathVariable("activityOrderId") int activityOrderId, Principal principal) {
	ActivityOrder actionOrder = activityOrderService.findActivityOrderById(activityOrderId);
	HistorySell historySell = HistorySellMapper.stickerBuyOnHistorySell(actionOrder);
	historySell.setUserBuy(principal.getName());
		historySellService.saveHistorySell(historySell);	
	
		stickerSafeService.deleteStickerSafe(activityOrderId);
		activityOrderService.deleteByActivityOrder(activityOrderId);
		return "redirect:/user";
	}
	@GetMapping("/finalyReturn/{activityOrderId}")
	public String finalyReturn(@PathVariable("activityOrderId") int activityOrderId) {
		StickerSafe stickerSafe = stickerSafeService.findOneStickerSafe(activityOrderId);
		Sticker sticker = StickerSafeMapper.stickerSafeOnSticker(stickerSafe);
		stickerService.saveSticker(sticker);
		stickerSafeService.deleteStickerSafe(activityOrderId);
//		ActivityOrder activityOrder = activityOrderService.findActivityOrderById(activityOrderId);
//		
//		HistorySell historySell = HistorySellMapper.stickerBuyOnHistorySell(activityOrder);
	//	
		//historySellService.saveHistorySell(historySell);
		
		activityOrderService.deleteByActivityOrder(activityOrderId);
		return "redirect:/user";
	}
	
	@GetMapping("/edit/{userId}")
	public String editUserProfile(
			@PathVariable("userId") int userId,
			Model model, Principal principal) {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		
		if (userId != entity.getId()) return "redirect:/user";
		EditUserRequest request = UserMapper.entityToEditUser(entity);
		model.addAttribute("editModel", request);
		return "user/edit";
	}
	
	@PostMapping("/edit/{userId}")
	public String saveEditedProfile(
			@ModelAttribute("editModel") EditUserRequest request,
			@PathVariable("userId") int userId
			) throws IOException {
		
		if (request.getFile().isEmpty()) {
			return "redirect:/user/edit/" + userId;
		}
		
		UserEntity entity = UserMapper.editRequestToEntity(request);
		System.out.println("pass: " + entity.getPassword());
		System.out.println("pass: " + entity.getRole());
		
		userService.editUser(entity);		
		CustomFileUtils.createFolder("user_" + entity.getId());
		CustomFileUtils.createImage("user_" + entity.getId(), request.getFile());
		
		return "redirect:/user";
	}
	
	
	
	@GetMapping("/{userId}/create")
	public String createAdvertisement(
			@PathVariable("userId") int userId,  
			Model model, 
			Principal principal) {
		UserEntity entity = userService.findUserByEmail(principal.getName());
		CreateAdvRequest advRequest = new CreateAdvRequest();
		advRequest.setEntity(entity);
		
		model.addAttribute("title", "Create Sticker");
		model.addAttribute("advModel", advRequest);
		model.addAttribute("stickerTypes", StickerType.values());
		model.addAttribute("aboutStickers", AboutSticker.values());
		
		
		
		return "user/create-adv";
	}
	
	@PostMapping("/{userId}/create")
	public String createAdvertisementForm(
			@ModelAttribute("advModel") CreateAdvRequest request,
			@PathVariable("userId") int userId, Model model
			) throws IOException {
		UserEntity entity = userService.findUserById(userId);
		Sticker sticker = StickerMapper.advRequestToSticker(request);
		sticker.setUser(entity);
		
		stickerService.saveSticker(sticker);
		model.addAttribute("stickerTypes", StickerType.values());
		CustomFileUtils.createFolder("sticker_" + sticker.getId());
		CustomFileUtils.createImage("sticker_" + sticker.getId(), request.getStickerImage());
		return "redirect:/user";
	}
	
	@GetMapping("/advs")
	public String showAllAdvertisement(Model model) throws IOException {
		List<Sticker> sticker = stickerService.findAllSticker();
		for(int i = 0; i < sticker.size(); i++) {
			String image = sticker.get(i).getStickerImage();
			sticker.get(i).setStickerImage(
					CustomFileUtils.getImage(
							"sticker_" + sticker.get(i).getId(), 
							image));
		}
		
		model.addAttribute("stickerList", sticker);
		return "user/advs";
	}
	
	@GetMapping("/activityorder")
	public String showActivityOrder(Model model, Principal principal)  {
	
		String userGet = principal.getName();
		ActivityOrder ao = activityOrderService.selectActivetyOrderByParticularUser(userGet);
		//	model.addAttribute("findAllActivityOrder", activityOrderService.findAllActivityOrder());
			model.addAttribute("findAllActivityOrder", 	ao);
	model.addAttribute("name", userGet);
		return "user/activityorder";
	}
	
@GetMapping("/history")
public String showHistory(Model model, Principal principal) {
	String userGet = principal.getName();
	HistorySell hs = historySellService.findParticularUserHistoryBuy(userGet);
	
	model.addAttribute("findParticularHistory", hs);
	model.addAttribute("name",userGet);

	return "user/history";
}
}