package com.example.shop.controller;

import com.example.shop.Entity.Product;
import com.example.shop.dto.ProductDto;
import com.example.shop.service.imp.ProductServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductControllerTest {
    @MockBean
    private  ProductServiceImp productServiceImp;
    @MockBean
    private  ProductController productController;

    @BeforeEach
    void setUp() {
        productController = new ProductController(productServiceImp);
    }

    @AfterEach
    void tearDown() {
        productController=null;
        productServiceImp=null;
    }

    @Test
    void addProduct() {
        ProductDto productDto = new ProductDto();
        doNothing().when(productServiceImp).addNewProduct(any(ProductDto.class));
        productController.addProduct(productDto);
        verify(productServiceImp, times(1)).addNewProduct(productDto);

    }

    @Test
    void getAllProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void getProductById() {
    }
}