package web.mapper;

import web.entity.ActivityOrder;
import web.entity.Sticker;
import web.entity.StickerSafe;
import web.entity.enumeration.StickerType;

public interface StickerSafeMapper {
	
	public static StickerSafe stickerOnStickerSafe(Sticker sticker) {
		StickerSafe stickerSafe = new StickerSafe();
		
		
		stickerSafe.setName(sticker.getName());
		stickerSafe.setPrice(sticker.getPrice());
		stickerSafe.setStickerType(sticker.getStickerType());
		stickerSafe.setAboutSticker(sticker.getAboutSticker());
		stickerSafe.setStickerImage(sticker.getStickerImage());
	//	stickerSafe.setUser(sticker.getUser());
		return stickerSafe;
	}
	
	public static Sticker stickerSafeOnSticker(StickerSafe stickerSafe) {
	Sticker sticker = new Sticker();
	
	sticker.setName(stickerSafe.getName());
	sticker.setPrice(stickerSafe.getPrice());
	sticker.setStickerType(stickerSafe.getStickerType());
		sticker.setAboutSticker(stickerSafe.getAboutSticker());
		sticker.setStickerImage(stickerSafe.getStickerImage());
		
	//	stickerSafe.setUser(sticker.getUser());
		return sticker;
	}
}
