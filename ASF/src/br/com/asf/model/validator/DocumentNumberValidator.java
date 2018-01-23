package br.com.asf.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentNumberValidator implements ConstraintValidator<DocumentNumber, String> {

	@Override
	public void initialize(DocumentNumber annotation) {
		
	}

	@Override
	public boolean isValid(String documentNumber, ConstraintValidatorContext context) {
		
		if(documentNumber == null) {
			return false;
		}
		
		if(documentNumber.toUpperCase().startsWith("A") && documentNumber.toUpperCase().endsWith("Z")) {
			return true;
		}
		else {
			return false;
		}
	}
}
