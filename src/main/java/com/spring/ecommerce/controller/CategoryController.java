package com.spring.ecommerce.controller;

import com.spring.ecommerce.dto.CategoryDto;
import com.spring.ecommerce.entity.Category;
import com.spring.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("Category")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {
        Category category=categoryService.createCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @GetMapping("getAllCategory")
    public ResponseEntity<List<Category>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
