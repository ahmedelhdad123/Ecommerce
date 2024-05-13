package com.spring.ecommerce.service;

import com.spring.ecommerce.dto.CategoryDto;
import com.spring.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(CategoryDto categoryDto);
    List<Category> getAllCategories();
}
