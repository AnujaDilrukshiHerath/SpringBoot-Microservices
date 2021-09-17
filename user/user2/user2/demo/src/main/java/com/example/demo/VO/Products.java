package com.example.demo.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private Date productExpiryDate;
    private Integer quantity;
    private Integer minQuantity;
}
