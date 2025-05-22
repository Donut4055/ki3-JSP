package com.example.ss11.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueCategoryNameValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCategoryName {
    String message() default "Tên danh mục đã tồn tại";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
