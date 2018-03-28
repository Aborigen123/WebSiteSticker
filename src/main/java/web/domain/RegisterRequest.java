package web.domain;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.entity.enumeration.Country;
import web.entity.enumeration.Role;
import web.validator.CheckPasswordsMatch;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordsMatch
public class RegisterRequest {

	// @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", message = "Typed email has not correct format")
	@NotEmpty private String email;
	@NotEmpty private String firstName;
	@NotEmpty private String lastName;
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirmation;
	 private Country country;
	private Role role;
	

}
