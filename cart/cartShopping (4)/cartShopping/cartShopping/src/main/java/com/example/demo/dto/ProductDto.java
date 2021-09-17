package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private Integer productId;
    private String productName;
    private Integer  productPrice;
    private Date productExpiryDate;
    private Integer quantity;
    private Integer minQuantity;

}
