package com.spring.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "street")
    private String street;

    @NotBlank
    @Column(name = "buildingName")
    private String buildingName;

    @NotBlank
    @Column(name = "state")
    private String state;

    @NotBlank
    @Column(name = "city")
    private String city;

    @NotBlank
    @Column(name = "zip")
    private String zip;

    @NotBlank
    @Column(name = "country")
    private String country;


    @ManyToMany(mappedBy = "address")
    private List<User> products=new ArrayList<>();

    public Address(String country, String state, String city, String zip, String street, String buildingName) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.street = street;
        this.buildingName = buildingName;
    }
}
