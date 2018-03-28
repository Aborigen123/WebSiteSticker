package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entity.Sticker;
import web.repository.StickerRepository;
import web.service.StickerService;

@Service
public class StickerServiceImpl implements StickerService{

	@Autowired StickerRepository carRepository;
	
	@Override
	public void saveSticker(Sticker sticker) {
		carRepository.save(sticker);
	}

	@Override
	public List<Sticker> findAllSticker() {
		return carRepository.findAll();
	}

	
	
}
