package com.spring.ecommerce.service;

import com.spring.ecommerce.dto.ProductDto;
import com.spring.ecommerce.entity.Category;
import com.spring.ecommerce.entity.Product;
import com.spring.ecommerce.repository.CategoryRepo;
import com.spring.ecommerce.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final CategoryRepo categoryRepo;


    @Override
    public ProductDto addProduct(ProductDto productDto) throws IOException {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImg(productDto.getImg().getBytes());

        Category category = categoryRepo.findById(productDto.getCategoryId()).orElseThrow();
        product.setCategory(category);
        return productRepo.save(product).getProductDto();
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(Product::getProductDto).collect(Collectors.toList());
    }

    public List<ProductDto> getProductByName(String name) {
        List<Product> products=productRepo.findByNameContains(name);
        return products.stream().map(Product::getProductDto).collect(Collectors.toList());
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> product=productRepo.findById(id);
        if(product.isPresent()) {
            productRepo.deleteById(id);
            return true;
        }else
        {
            return false;
        }
    }
}
