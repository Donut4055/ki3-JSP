package com.example.ss11.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.ss11.model.Category;
import com.example.ss11.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCategoryName, Category> {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context) {
        if (category.getId() == null) {
            return categoryDAO.findByName(category.getCategoryName()) == null;
        } else {
            return categoryDAO.findByNameAndNotId(category.getCategoryName(), category.getId()) == null;
        }
    }
}
