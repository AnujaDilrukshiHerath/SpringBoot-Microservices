package com.example.demo.ResponseTemplete;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartHasProduct;
import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTempleteCartHasProduct {
    private Cart cart;
    private Product product;
    private CartHasProduct cartHasProduct;
}
