package web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web.domain.RegisterRequest;
import web.service.UserService;

@Component
public class UniqueEmailValidator  implements ConstraintValidator<UniqueEmail, String> {
	@Autowired UserService userService;
	@Override
	public void initialize(UniqueEmail uniqueEmail) {
		
		
	}


	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if(email== null ) {
			return false;
		}
		
		if(userService.findUserByEmail(email) != null) {
			return false;
		}else {
			return true;
		}}

}
