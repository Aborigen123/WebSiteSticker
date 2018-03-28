package web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UserProfileRequest {

	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private int age;
}
