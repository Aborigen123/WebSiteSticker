package web.mapper;

import web.domain.CreateAdvRequest;
import web.domain.ShowSelect;
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
	
	
	public static  Sticker getStickerT(ShowSelect ss) {
		Sticker sticker = new Sticker();
	sticker.setStickerType(ss.getStickerType());
	
	return sticker;
}

public static  ShowSelect setStickerT(Sticker sticker) {
	ShowSelect ss = new ShowSelect();
	ss.setStickerType(sticker.getStickerType());
	
	return ss;
}
}
