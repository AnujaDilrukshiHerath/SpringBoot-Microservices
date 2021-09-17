package com.example.demo.service;

import com.example.demo.dto.CartHasProductDto;
import com.example.demo.entity.CartHasProduct;
import javassist.NotFoundException;

import java.util.List;

public interface CartHasProductService {
    CartHasProductDto getCartProduct(int cartHasProductId) throws NotFoundException;
    List<CartHasProduct> getCartProducts();
    String addCartProduct(CartHasProductDto cartHasProductDto);
    void deleteCartProduct(Integer cartHasProductId);
    CartHasProduct updateCartProduct(CartHasProductDto cartHasProductDto);
}
