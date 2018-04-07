package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entity.StickerSafe;
import web.repository.StickerSafeRepository;
import web.service.StickerSafeService;

@Service
public class StickerSafeServiceImpl implements StickerSafeService {

	@Autowired StickerSafeRepository stickerSafeRepository;
	@Override
	public void saveStickerSafe(StickerSafe stickerSafa) {
		stickerSafeRepository.save(stickerSafa);
		
	}

	@Override
	public void deleteStickerSafe(int id) {
		stickerSafeRepository.delete(id);
		
	}

	@Override
	public List<StickerSafe> findAllStickerSafe() {
		
		return stickerSafeRepository.findAll();
	}

	@Override
	public StickerSafe findOneStickerSafe(int id) {
		
		return stickerSafeRepository.findOne(id);
	}

}
