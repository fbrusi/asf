package br.com.asf.model.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = DocumentNumberValidator.class)
public @interface DocumentNumber {

	String message() default "{model.validator.invalid_document_number}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
