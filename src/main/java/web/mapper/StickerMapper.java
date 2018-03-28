package web.mapper;

import web.domain.CreateAdvRequest;
import web.entity.Sticker;

public interface StickerMapper {

	public static Sticker advRequestToSticker(CreateAdvRequest advRequest) {
		Sticker sticker = new Sticker();
	sticker.setName(advRequest.getName());
	sticker.setPrice(advRequest.getPrice());
	sticker.setStickerType(advRequest.getStickerType());
	sticker.setAboutSticker(advRequest.getAboutSticker());
		sticker.setUser(advRequest.getEntity());
		sticker.setStickerImage(advRequest.getStickerImage().getOriginalFilename());
		return sticker;
	}
}
