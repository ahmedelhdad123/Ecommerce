package com.spring.ecommerce.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private byte [] byteImg;
    private Long categoryId;
    private MultipartFile img;
}
