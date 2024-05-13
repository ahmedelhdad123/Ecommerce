package com.spring.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.ecommerce.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    private String name;

    private double price;

    @Lob
    private String description;

    @Lob
    private byte [] img;

    private int capacity;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<OrderItem> orders=new ArrayList<>();

    @OneToMany(mappedBy = "product",cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<CartItem> cart=new ArrayList<>();

    public ProductDto getProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setName(name);
        productDto.setPrice(price);
        productDto.setDescription(description);
        productDto.setByteImg(img);
        productDto.setCategoryId(category.getId());
        return productDto;
    }

}
