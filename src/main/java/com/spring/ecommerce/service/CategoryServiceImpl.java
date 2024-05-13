package com.spring.ecommerce.service;

import com.spring.ecommerce.dto.CategoryDto;
import com.spring.ecommerce.entity.Category;
import com.spring.ecommerce.repository.CategoryRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo   categoryRepo;


    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
