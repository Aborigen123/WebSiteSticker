package web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import web.entity.Sticker;

public interface StickerService {

	void saveSticker(Sticker sticker);
	
	List<Sticker> findAllSticker();
	
	Page<Sticker> findAllStickerByPage(Pageable pageable);
}
