package com.spring.ecommerce.controller;

import com.spring.ecommerce.dto.ProductDto;
import com.spring.ecommerce.entity.Product;
import com.spring.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("addProduct")
    public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException {
        ProductDto productDto1=productService.addProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }

    @GetMapping("getAllProduct")
    public ResponseEntity<List<ProductDto>> getAllProduct()  {
        List<ProductDto> productDtos=productService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("search/{name}")
    public ResponseEntity<List<ProductDto>> getProductByName(@PathVariable String name)
    {
        List<ProductDto> productDtos=productService.getProductByName(name);
        return ResponseEntity.ok(productDtos);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean delete=productService.deleteProduct(id);
        if (delete)
        {
            return ResponseEntity.noContent().build();
        }else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
