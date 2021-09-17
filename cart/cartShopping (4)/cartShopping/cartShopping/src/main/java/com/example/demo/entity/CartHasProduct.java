package com.example.demo.entity;

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
        @Column(name = "cartHasProductId")
        private Integer cartHasProductId;
        @Column(name = "cart_cartId")
        private Integer cartId;
        @Column(name = "product_productId")
        private Integer product_productId;
        @Column(name = "quantity")
        private Integer quantity;




    }


