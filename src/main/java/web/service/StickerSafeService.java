package web.service;

import java.util.List;

import web.entity.StickerSafe;

public interface StickerSafeService {

	void saveStickerSafe(StickerSafe stickerSafa);
	
	void deleteStickerSafe(int id);
	
	List<StickerSafe> findAllStickerSafe();
	
	StickerSafe findOneStickerSafe(int id);
}
