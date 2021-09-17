package com.example.shop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_has_product")
public class CartHasProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_cartId")
    private Integer cartId;
    @Column(name = "product_productId")
    private Integer productId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "cartHasProductId")
    private Integer cartProductId;



}
