package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import web.entity.Sticker;
import web.entity.enumeration.StickerType;
import web.service.StickerService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {
	
@Autowired StickerService stickerService;

	@GetMapping("/test")
	public String sayHello() {
		
		return "Hello World";
	}
	
	@GetMapping("/products")
	public List<Sticker> getStickers(){
		
		return stickerService.findAllSticker();
	}
	
//	@GetMapping("/buy")
//	public ResponseEntity<?> buy(@RequestParam("carEntityId")String carEntityId){
//		int cid = Integer.valueOf(carEntityId);
//		CarEntity entity = carEntityService.findCarEntitybyid(cid);
//		entity.setInStock(entity.getInStock() - 1);
//		carEntityService.saveOrUpdate(entity);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}
