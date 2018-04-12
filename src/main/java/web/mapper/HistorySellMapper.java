package web.mapper;

import web.entity.ActivityOrder;
import web.entity.HistorySell;
import web.entity.Sticker;


public interface HistorySellMapper {

	public static HistorySell stickerBuyOnHistorySell(ActivityOrder activityOrder) {
		HistorySell historySell = new HistorySell();
		historySell.setId(activityOrder.getId());
		historySell.setName(activityOrder.getName());
		historySell.setPrice(activityOrder.getPrice());
		historySell.setStickerImage(activityOrder.getStickerImage());
		historySell.setUserBuy(activityOrder.getUserCustomer());
		return historySell;
	}
	
	
	public static HistorySell nowBuy(Sticker sticker) {
		HistorySell historySell = new HistorySell();
		historySell.setId(sticker.getId());
		historySell.setName(sticker.getName());
		historySell.setPrice(sticker.getPrice());
		historySell.setStickerImage(sticker.getStickerImage());
		return historySell;
	}
}
