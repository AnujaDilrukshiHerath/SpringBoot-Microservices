/*
package com.example.demo.dao;

import com.example.demo.dto.CartDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CartRepositoryTest {
    private Cart savedProduct;

    @Autowired
    private CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        CartDto cartDto=new CartDto();
        cartDto.setCartId(1);
        cartDto.setSubTotal(5);
        //cartDto.setUser_userId(1);
        Cart cart=new Cart();
        cart.setCartId(cartDto.getCartId());
        cart.setSubTotal(cartDto.getSubTotal());
        //User user = new User();
        //user.getUser_userId(cartDto.getUser_userId());
        savedProduct=cartRepository.save(cart);
        assertNotNull(cart);
    }

    @AfterEach
    void tearDown() {
        savedProduct=null;
        cartRepository=null;
        testDeleteProduct();
    }
    @Test
    void testUpdateProduct() {

        Optional<Cart> cartOptional = cartRepository.findById(savedProduct.getCartId());
        Cart cart=cartOptional.get();
        cart.setCartId(1);
        cart.setSubTotal(6);
        Cart cart1 = cartRepository.save(cart);
        Assertions.assertNotNull(cart1);

    }
    @Test
    void testProductById(){
        Optional<Cart> cart = cartRepository.findById(savedProduct.getCartId());
        assertNotNull(cart.get());
        Assertions.assertEquals(Optional.of(this.savedProduct),cart);
    }

    void testDeleteProduct() {
        cartRepository.delete(savedProduct);
        Optional<Cart> optionalProduct = cartRepository.findById(savedProduct.getCartId());
        Assertions.assertEquals(Optional.empty(), optionalProduct);
        Assertions.assertNotEquals(Optional.of(savedProduct), optionalProduct);
    }
    @Test
    void testGetProduct(){

        List<Cart> carts= cartRepository.findAll();
        Assertions.assertNotNull(carts);

    }


}*/
