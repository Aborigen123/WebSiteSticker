package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import web.entity.Sticker;
import web.repository.StickerRepository;
import web.service.StickerService;

@Service
public class StickerServiceImpl implements StickerService{

	@Autowired StickerRepository stickerRepository;
	
	@Override
	public void saveSticker(Sticker sticker) {
		stickerRepository.save(sticker);
	}

	@Override
	public List<Sticker> findAllSticker() {
		return stickerRepository.findAll();
	}

	@Override
	public Page<Sticker> findAllStickerByPage(Pageable pageable) {
		PageRequest request = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(),pageable.getSort());
		
		return stickerRepository.findAll(request);
	}
//	@Override
//	public void random() {
//		
//		for(int i = 0; i<40; i++) {
//			Sticker sticker = new Sticker();
//			sticker.setName("Name #"+1);
//			
//			Sticker savedSticker = stickerRepository.save(sticker);
//			
//		}
//
//		
//	}
//	
}
