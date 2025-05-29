package com.example.ss13.validator;


import com.example.ss13.model.UserRegister;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PasswordMatchValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegister.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegister dto = (UserRegister) target;
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "register.password.mismatch");
        }
    }
}

