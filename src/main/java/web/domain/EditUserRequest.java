package web.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.entity.enumeration.Role;

@NoArgsConstructor
@Getter @Setter
public class EditUserRequest {
	private int id;
	private String email;
	private String password;	
	private String firstName;
	private String lastName;
	private int age;
	private MultipartFile file;
	private Role role;
	private String phoneNumber;
}
