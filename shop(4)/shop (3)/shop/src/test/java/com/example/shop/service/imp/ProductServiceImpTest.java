package com.example.shop.service.imp;

import com.example.shop.Entity.Product;
import com.example.shop.dao.ProductDao;
import com.example.shop.dto.ProductDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class ProductServiceImpTest {
    private ProductServiceImp productServiceImp;

    @MockBean
    private ProductDao productDao;

    @BeforeEach
    void setUp() {
        productServiceImp=new ProductServiceImp(productDao);
    }

    @AfterEach
    void tearDown() {
        productDao=null;
        productServiceImp=null;
    }

    @Test
    void addNewProduct() {
        ProductDto productDto=new ProductDto();
        productDto.setProductId(1);
        productDto.setProductName("apple");
        Product product=new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        when(productDao.save(any(Product.class))).thenReturn(product);
        productServiceImp.addNewProduct(productDto);
        verify(productDao,times(1)).save(any(Product.class));
    }

    @Test
    void getAllProducts() {
        Product product=new Product();
        product.setProductId(1);
        product.setProductName("apple");
        ProductDto productDto=new ProductDto();
        productDto.setProductId(1);
        productDto.setProductName("apple");

        List<Product> productList=new ArrayList<>();
        productList.add(product);

        when(productDao.findAll()).thenReturn(productList);
        List<ProductDto> productDtoList=new ArrayList<>();
        productDtoList.add(productDto);

        productDtoList=productServiceImp.getAllProducts();

        assertNotNull(productDtoList);
        assertTrue(productDtoList.size() > 0);


    }

    @Test
    void getProductsById() {
        Integer id =1;
        Optional<Product> product = Optional.of(new Product());
        when(productDao.findById(id)).thenReturn(product);

        ProductDto productsById = productServiceImp.getProductsById(id);
        assertNotNull(productsById);

    }

    @Test
    void modifiedNewProduct() {
        ProductDto productDto=new ProductDto();
        productDto.setProductId(1);
        productDto.setProductName("apple");

        Product product=new Product();
        product.setProductId(1);
        product.setProductName("apple");

    }

    @Test
    void deleteProductsBYid() {
        Integer Id=1;
        when(productDao.findById(Id)).thenReturn(Optional.of(new Product()));
        productServiceImp.deleteProductsBYid(Id);
        verify(productDao,times(1)).delete(any(Product.class));

    }
}