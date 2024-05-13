package com.spring.ecommerce.service;

import com.spring.ecommerce.dto.ProductDto;
import com.spring.ecommerce.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    ProductDto addProduct(ProductDto productDto) throws IOException;
    List<ProductDto> getAllProducts();
    List<ProductDto> getProductByName(String name);
    boolean deleteProduct(Long id);
}
