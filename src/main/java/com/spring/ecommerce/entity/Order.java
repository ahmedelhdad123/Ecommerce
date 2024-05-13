package com.spring.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "orderDate")
    @CreationTimestamp
    private Date orderDate;

    @Column(name = "totalAmount")
    private Double totalAmount;


    @OneToMany(mappedBy = "order" ,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Set<OrderItem> orderItems;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;


}
