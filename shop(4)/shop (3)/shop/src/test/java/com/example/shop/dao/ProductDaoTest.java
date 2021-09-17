package com.example.shop.dao;

import com.example.shop.Entity.Product;
import com.example.shop.dto.ProductDto;
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
class ProductDaoTest {
    private Product savedProduct;

    @Autowired
    private ProductDao productDao;

    @BeforeEach
    void setUp() {
        ProductDto productDto=new ProductDto();
        productDto.setProductId(1);
        productDto.setProductName("apple");
        Product product=new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        savedProduct=productDao.save(product);
        assertNotNull(product);
    }

    @AfterEach
    void tearDown() {
        savedProduct=null;
        productDao=null;
        testDeleteProduct();
    }
    @Test
    void testUpdateProduct() {

        Optional<Product> productOptional = productDao.findById(savedProduct.getProductId());
        Product product=productOptional.get();
        product.setProductId(1);
        product.setProductName("apple");
        Product product1 = productDao.save(product);
        Assertions.assertNotNull(product1);

    }
    @Test
    void testProductById(){
        Optional<Product> product = productDao.findById(savedProduct.getProductId());
        assertNotNull(product.get());
        Assertions.assertEquals(Optional.of(this.savedProduct),product);
    }

    void testDeleteProduct() {
        productDao.delete(savedProduct);
        Optional<Product> optionalProduct = productDao.findById(savedProduct.getProductId());
        Assertions.assertEquals(Optional.empty(), optionalProduct);
        Assertions.assertNotEquals(Optional.of(savedProduct), optionalProduct);
    }
    @Test
    void testGetProduct(){

        List<Product> products = productDao.findAll();
        Assertions.assertNotNull(products);

    }
}