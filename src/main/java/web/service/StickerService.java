package web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import web.domain.StickerNameFilter;
import web.entity.Sticker;
import web.entity.UserEntity;

public interface StickerService {

	void saveSticker(Sticker sticker);
	
	List<Sticker> findAllSticker();
	
	Page<Sticker> findAllStickerByPage(Pageable pageable);
	
	Page<Sticker> findStickerByName(Pageable pageable, StickerNameFilter filter);
	
	void deleteByBuy1(Sticker sticker);

	void deleteByBuy(int id);

	Sticker deleteBuy(int id);
	
}
