package web.mapper;

import web.entity.ActivityOrder;
import web.entity.Sticker;

public interface ActivityOrderMapper {

	
	
	public static ActivityOrder stickerOnActivityOrder(Sticker sticker) {
		ActivityOrder activyOrder = new ActivityOrder();
		activyOrder.setId(sticker.getId());
		activyOrder.setName(sticker.getName());
		activyOrder.setPrice(sticker.getPrice());
		activyOrder.setStickerImage(sticker.getStickerImage());
		return activyOrder;
	}
}
