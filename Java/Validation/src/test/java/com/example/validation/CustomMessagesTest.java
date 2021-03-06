package com.example.validation;

import com.example.validation.dto.LoginForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomMessagesTest {

    @Qualifier("LocalValidator")
    @Autowired
    private LocalValidatorFactoryBean localValidatorFactoryBean;

    @Test
    public void validate_givenInvalidLoginFormWithCustomMessage_willReturnCustomMessage() {
        LoginForm invalidLoginForm = new LoginForm("", "password");

        Validator validator = localValidatorFactoryBean.getValidator();
        Set<ConstraintViolation<LoginForm>> validations = validator.validate(invalidLoginForm);

        String message = validations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList())
                .get(0);

        assertEquals("Some email message from a file", message);
    }
}
