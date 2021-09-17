package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.Cart;
import javassist.NotFoundException;

import java.util.List;

public interface CartService {
    CartDto getCart(int cartId) throws NotFoundException;
    List<Cart> getCarts();
    String addCart(CartDto cartDto);
    void deleteCart(Integer cartId);
    Cart updateCart(CartDto cartDto);
}
