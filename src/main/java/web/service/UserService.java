package web.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import web.entity.Sticker;
import web.entity.UserEntity;


public interface UserService {

	void saveUser(UserEntity entity);
	
	void editUser(UserEntity entity);
	
	UserEntity findUserById(int id);
	
	UserEntity findUserByEmail(String email);
	
	List<UserEntity> findUserAll();

	UserEntity blockUser(int id);
	
	
	

}
