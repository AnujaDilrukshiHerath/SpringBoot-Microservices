package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartHasProduct {
    @Id
    @Column(name = "cart_cartId")
    private Integer cart_cartId;
    @Column(name = "product_productId")
    private Integer product_productId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "cartHasProductId")
    private Integer cartHasProductId;
}
