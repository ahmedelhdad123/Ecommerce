package com.spring.ecommerce.entity;


import com.spring.ecommerce.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String userName;


    private String password;

    private UserRole role;


    @Lob
    private byte[] image;


    @Email
    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "user_address",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addressList=new ArrayList<>();

    @OneToOne(mappedBy = "user",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Cart cart;

}
