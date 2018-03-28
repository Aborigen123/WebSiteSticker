package web.service;

import java.util.List;

import web.entity.Sticker;

public interface StickerService {

	void saveSticker(Sticker sticker);
	
	List<Sticker> findAllSticker();
}
