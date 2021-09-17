package com.example.demo.entity;


import lombok.*;
/*
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
*/

import javax.persistence.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "cartId")
    private Integer cartId;
    @Column(name="subTotal")
    private Integer subTotal;
    @Column(name = "user_userId")
    private Integer user_userId;


}
