package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartHasProductDto {

    private Integer cartId;
    private Integer product_productId;
    private Integer quantity;
    private Integer cartHasProductId;

}
