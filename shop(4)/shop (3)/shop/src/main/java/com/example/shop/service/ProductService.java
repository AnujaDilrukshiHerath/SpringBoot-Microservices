package com.example.shop.service;

import com.example.shop.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {

    void addNewProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductsById(Integer productId);
    void modifiedNewProduct(ProductDto productDto) throws Exception;
    void deleteProductsBYid(Integer productId);




}
