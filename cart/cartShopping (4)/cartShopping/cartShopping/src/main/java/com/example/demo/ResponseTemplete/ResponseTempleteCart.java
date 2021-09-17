package com.example.demo.ResponseTemplete;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartHasProduct;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTempleteCart {
    private List<ProductDto> productDtoList;

    private Cart cart;
    private CartHasProduct cartHasProduct;
}
