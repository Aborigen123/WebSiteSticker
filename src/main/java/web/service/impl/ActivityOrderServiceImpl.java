package web.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entity.ActivityOrder;
import web.entity.Sticker;
import web.entity.UserEntity;
import web.repository.ActivityOrderRepository;
import web.repository.StickerRepository;
import web.service.ActivityOrderService;

@Service
public class ActivityOrderServiceImpl implements ActivityOrderService {
	@Autowired ActivityOrderRepository activityOrderRepository;
	@Autowired StickerRepository stickerRepository;

	@Override
	public void saveAddToActivity(ActivityOrder ao) {
		activityOrderRepository.save(ao);
		
	}

	@Override
	public List<ActivityOrder> findAllActivityOrder() {
		
		return activityOrderRepository.findAll();
	}

	@Override
	public ActivityOrder findActivityOrderById(int id) {
		
		return activityOrderRepository.findOne(id);
	}

	@Override
	public void deleteByActivityOrder(int id) {
		activityOrderRepository.delete(id);
		
	}



	@Override
	public ActivityOrder selectActivetyOrderByParticularUser(String userCustomer) {
	
		return activityOrderRepository.selectActivetyOrderByParticularUser(userCustomer);
	}


}
