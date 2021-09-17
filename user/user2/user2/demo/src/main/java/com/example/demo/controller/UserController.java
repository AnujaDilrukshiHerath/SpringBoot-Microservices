package com.example.demo.controller;

import com.example.demo.VO.ResponeTemplateVO;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;
    private Cart cart;
    RestTemplate restTemplate=new RestTemplate();

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto){
      userService.addUser(userDto);
        return new ResponseEntity<User>( HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<UserDto> getAllUsers(){
     return    userService.getAllUsers();
       // return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }


    @GetMapping("getUserCart/{id}")
    public ResponeTemplateVO getUserWithCart(@PathVariable("id") Integer userId){
        return userService.getUserWithCartId(userId);

    }

//    @GetMapping("getProducts/{id}")
//    public ResponeTemplateVO getproductWithCart(@PathVariable("id") Integer id){
//        return userService.getproctwithCart(id);
//    }


}
