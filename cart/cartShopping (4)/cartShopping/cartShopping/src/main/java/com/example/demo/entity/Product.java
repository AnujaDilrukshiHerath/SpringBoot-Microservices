package com.example.demo.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product" )
public class Product {
    @Id
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productPrice")
    private Integer productPrice;
    @Column(name = "productExpiryDate")
    private Date productExpiryDate;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "minQuantity")
    private Integer minQuantity;

}
