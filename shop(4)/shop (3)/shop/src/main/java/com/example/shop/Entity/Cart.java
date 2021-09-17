package com.example.shop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Integer cartId;
    @Column(name="subTotal")
    private Integer subTotal;

    /*@ManyToMany(mappedBy = "cart")
    private Integer user_userId;*/

}
