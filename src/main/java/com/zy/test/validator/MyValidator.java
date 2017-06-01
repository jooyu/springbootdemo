package com.zy.test.validator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.validation.Errors;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zy.test.util.ObjectMapperFactory;

@JsonIgnoreProperties(ignoreUnknown = true)

@Configurable(autowire = Autowire.BY_NAME)
public class MyValidator implements org.springframework.validation.Validator {
	static final ObjectMapper objectMapper = ObjectMapperFactory
			.getCookierunRequestObjectMapper();
	static final ValidatorFactory factory = Validation
			.buildDefaultValidatorFactory();
	static final Validator validator = factory.getValidator();
	static Logger logger = LoggerFactory.getLogger(MyValidator.class);
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

	
}
