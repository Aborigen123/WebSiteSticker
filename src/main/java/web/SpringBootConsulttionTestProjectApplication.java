package web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import web.entity.Sticker;
import web.entity.UserEntity;
import web.entity.enumeration.AboutSticker;
import web.entity.enumeration.Role;
import web.entity.enumeration.StickerType;
import web.repository.StickerRepository;
import web.repository.UserRepository;

@SpringBootApplication
public class SpringBootConsulttionTestProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootConsulttionTestProjectApplication.class);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootConsulttionTestProjectApplication.class, args);
		addAdmin(context);
	//	addSticker(context);
		addUser(context);
		
	}
	
	static void addAdmin(ConfigurableApplicationContext context) {
		String adminEmail = "admin@gmail.com";
		String adminPassword = "123";
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		UserEntity entity = userRepository.findUserByEmail(adminEmail);
		if(entity == null) {
			PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
			
			entity = new UserEntity();
			entity.setEmail(adminEmail);
			entity.setPassword(encoder.encode(adminPassword));
			entity.setRole(Role.ROLE_ADMIN);
			
			userRepository.save(entity);
		}
	}
	
	static void addUser(ConfigurableApplicationContext context) {
		UserRepository userRepository = context.getBean(UserRepository.class);
		UserEntity user = userRepository.findOne(1);
		
		if(user == null) {
			userRepository.save(getUser());
		}
		
	}
	
	private static List<UserEntity> getUser(){
		List<UserEntity> user = new ArrayList<>();
		
		user.add(new UserEntity("ib", "123","FirstName","SecondName",12, "data:image/png;base64,12442.png"));
	
		
		
		return user;
	}
	
	
	static void addSticker(ConfigurableApplicationContext context) {
		StickerRepository stickerRepository = context.getBean(StickerRepository.class);
		Sticker carentity = stickerRepository.findOne(1);
		
		if(carentity == null) {
			stickerRepository.save(getStickers());
		}
		
	}
	
	private static List<Sticker> getStickers(){
		List<Sticker> sticker = new ArrayList<>();
		
		for(int i =0; i<50; i++) {
		sticker.add(new Sticker("BMW"+ i,null , StickerType.Holo, AboutSticker.Car, null, null));
		}
		
		
		return sticker;
	}
	
}
