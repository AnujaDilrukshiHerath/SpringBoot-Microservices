package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userPhoneNumber")
    private Integer phoneNumber;
    @Column(name = "userAddress")
    private String userAddress;




//    @OneToOne(mappedBy = "user",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY,orphanRemoval = true)
//    private Cart cart;
}
