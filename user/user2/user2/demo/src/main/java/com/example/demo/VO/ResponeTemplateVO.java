package com.example.demo.VO;

import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponeTemplateVO {
    private User user;
    private Cart cart;

    private Products products;
}
