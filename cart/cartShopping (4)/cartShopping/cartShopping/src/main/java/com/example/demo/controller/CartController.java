package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import com.example.demo.ResponseTemplete.ResponseTempleteCart;
import com.example.demo.entity.Cart;
import com.example.demo.service.impl.CartServiceImpl;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }



   @GetMapping("/getCarts")
    public List<Cart> getCarts(Integer userId) {

        return cartService.getCarts();
    }

   @GetMapping(value = "/getCartById/{id}")
    public CartDto getCart(@PathVariable("id") int cartId) throws NotFoundException {
        return cartService.getCart(cartId);
    }

    @PostMapping
    public ResponseEntity<?> addCart(@RequestBody CartDto cartGetDto, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
        }

        String c = cartService.addCart(cartGetDto);
        return new ResponseEntity<String>(c, HttpStatus.CREATED);
    }

    @PutMapping()
    public Cart updateCart(@RequestBody CartDto cartGetDto) {
        Cart cart = cartService.updateCart(cartGetDto);
        return cart;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable("id") int cartId) {
        cartService.deleteCart(cartId);
    }
/*
    @PostMapping("/")
            public Cart saveCart(@RequestBody Cart cart) {
        log.info("inside save cart method of cart Controller");
        return cartService.saveCart(cart);

    }*/

   /*@GetMapping("/{id}")
    public Cart findById(@PathVariable("id") Integer cartId){
        log.info("inside save cart method of cart Controller");
        return cartService.findById(cartId);
    }*/
    @GetMapping("/getCart/{id}")
    public CartDto getCartWithCartId(@PathVariable("id") Integer cartId) throws NotFoundException {
        log.info("inside save cart method of get cart with cart id");
        return cartService.getCart(cartId);
        //return cartService.getCartWithCartId(cartId);
    }

    @GetMapping("/cartProduct/{id}")
    public ResponseTempleteCart getCartProduct(@PathVariable("id")Integer cartId){
        log.info("inside save cart method of get cart and user with cart id");
        return cartService.getCartProduct(cartId);
    }

}
