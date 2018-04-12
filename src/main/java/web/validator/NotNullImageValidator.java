package web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import web.domain.CreateAdvRequest;

@Component
public class NotNullImageValidator implements ConstraintValidator<NotNullImage, CreateAdvRequest>{

	@Override
	public void initialize(NotNullImage arg0) {
		
		
	}

	@Override
	public boolean isValid(CreateAdvRequest value, ConstraintValidatorContext context) {
	
		if(value == null ) {
			return false;
		}
		else {
			return true;
		}

	
	}
}
