package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-carts")
public class UserResorces {

    @PostMapping
    public String saveUser(@RequestBody User user){
return null;
    }
}
