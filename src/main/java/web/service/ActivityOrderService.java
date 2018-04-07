package web.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import web.entity.ActivityOrder;

public interface ActivityOrderService {
	
 void saveAddToActivity(ActivityOrder ao);
 
 List<ActivityOrder> findAllActivityOrder();
 
 ActivityOrder findActivityOrderById(int id);
 
 void deleteByActivityOrder(int id);

//void saveAddToActivityOrder1(String name, BigDecimal price, String firstName);
 
}
