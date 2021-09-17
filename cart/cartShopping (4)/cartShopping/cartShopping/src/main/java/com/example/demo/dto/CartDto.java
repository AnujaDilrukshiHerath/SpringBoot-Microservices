package com.example.demo.dto;

import lombok.*;

 @Getter
 @Setter
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
    public class CartDto {
        private Integer cartId;
        private Integer subTotal;
        private Integer user_userId;

     }

