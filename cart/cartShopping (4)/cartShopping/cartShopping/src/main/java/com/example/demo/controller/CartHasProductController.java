package com.example.demo.controller;

import com.example.demo.ResponseTemplete.ResponseTempleteCartHasProduct;
import com.example.demo.dto.CartHasProductDto;
import com.example.demo.entity.CartHasProduct;
import com.example.demo.service.impl.CartHasProductImpl;
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
@RequestMapping("/cartProduct")
@Slf4j
public class CartHasProductController {

    @Autowired
    private CartHasProductImpl cartHasProductImpl;

    @Autowired
    public CartHasProductController(CartHasProductImpl cartHasProduct) {
        this.cartHasProductImpl = cartHasProduct;
    }


    @GetMapping("/getCartProducts")
    public List<CartHasProduct> getCartProducts(Integer productId) {

        return cartHasProductImpl.getCartProducts();
    }

    @GetMapping(value = "/getCartProductById/{id}")
    public CartHasProductDto getCartProduct(@PathVariable("id") int cartHasProductId) throws NotFoundException {
        return cartHasProductImpl.getCartProduct(cartHasProductId);
    }


    @PostMapping
    public ResponseEntity<?> addCartProduct(@RequestBody CartHasProductDto cartHasProductDto, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
        }

        String c = cartHasProductImpl.addCartProduct(cartHasProductDto);
        return new ResponseEntity<String>(c, HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCartProduct(@PathVariable("id") int cartHasProductId) {
        cartHasProductImpl.deleteCartProduct(cartHasProductId);
    }
    @PutMapping()
    public CartHasProduct updateCartProduct(@RequestBody CartHasProductDto cartHasProductDto) {
        CartHasProduct cartHasProduct = cartHasProductImpl.updateCartProduct(cartHasProductDto);
        return cartHasProduct;
    }

    @GetMapping("/getCartProduct/{id}")
    public CartHasProductDto getCartWithCartProductId(@PathVariable("id") Integer cartHasProductId) throws NotFoundException {
        log.info("inside save cart method of get cart with cart product id");
        return cartHasProductImpl.getCartProduct(cartHasProductId);

    }

    /*@GetMapping("/cartProductId/{id}")
    public CartHasProductDto getCartWithProduct(@PathVariable("id")Integer cartHasProductId) throws NotFoundException {
        log.info("inside save cart method of get cart and product with cart product id");
       return cartHasProductImpl.getCartProduct(cartHasProductId);
    }*/
    /*@GetMapping("/{id}")
    public Cart findById(@PathVariable("id") Integer cartId){
        log.info("inside save cart method of cart Controller");
        return cartService.findById(cartId);
    }*/


/*
    @GetMapping("/cartHasProduct/{id}")
    public ResponseTempleteCartHasProduct getCartHasProduct(@PathVariable("id")Integer id){
        log.info("inside save cart method of get cart and user with cart id");
        return cartHasProductImpl.getCartHasProduct(id);
    }*/


}