package com.example.demo.entity;

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
    @GeneratedValue
    @Column(name = "cartId")
    private Integer cartId;
    @Column(name = "subTotal")
    private Integer subTotal;

        /*@ManyToMany(mappedBy = "cart")
    private Integer user_userId;*/

//    @OneToOne(mappedBy = "cart",cascade = CascadeType.ALL)
//    User user;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_userId",referencedColumnName = "userId")
//    private User user;
}


