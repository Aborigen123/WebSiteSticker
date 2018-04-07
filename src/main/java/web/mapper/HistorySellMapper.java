package web.mapper;

import web.entity.ActivityOrder;
import web.entity.HistorySell;


public interface HistorySellMapper {

	public static HistorySell stickerBuyOnHistorySell(ActivityOrder activityOrder) {
		HistorySell historySell = new HistorySell();
		historySell.setId(activityOrder.getId());
		historySell.setName(activityOrder.getName());
		historySell.setPrice(activityOrder.getPrice());
		historySell.setStickerImage(activityOrder.getStickerImage());
		return historySell;
	}
}
