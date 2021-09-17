package com.example.shop.service.imp;

import com.example.shop.Entity.Product;
import com.example.shop.dao.ProductDao;
import com.example.shop.dto.ProductDto;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
    private ProductDao productDao;
    List<ProductDto> productArrayList=new ArrayList<>();
    @Autowired
    public ProductServiceImp(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductPrice(productDto.getProductPrice());
        product.setProductName(productDto.getProductName());
        product.setProductExpiryDate(productDto.getProductExpiryDate());
        product.setMinQuantity(productDto.getMinQuantity());
        product.setQuantity(productDto.getQuantity());
        productDao.save(product);
    }

    @Override

    public List<ProductDto> getAllProducts() {
        return  productDao.findAll().stream().map(Product -> {

            ProductDto productDto = new ProductDto();
            productDto.setProductId(Product.getProductId());
            productDto.setProductName(Product.getProductName());
            productDto.setProductPrice(Product.getProductPrice());
            productDto.setProductExpiryDate(Product.getProductExpiryDate());
            productDto.setMinQuantity(Product.getMinQuantity());
            productDto.setQuantity(Product.getQuantity());
            return productDto;
        }).collect(Collectors.toList());
    }


    @Override
    public ProductDto getProductsById(Integer productId) {
        Optional<Product> product=productDao.findById(productId);
        if(product.isPresent()) {
            Integer productId1=product.get().getProductId();
            String productName=product.get().getProductName();
            Integer productPrice=product.get().getProductPrice();
            Date productExpiryDate=product.get().getProductExpiryDate();
            Integer productMinQuantity=product.get().getMinQuantity();
            Integer quantity= product.get().getQuantity();
            return new ProductDto(productId1,productName,productPrice,productExpiryDate,quantity,productMinQuantity);
        }
        return null;
    }

    @Override
    public void modifiedNewProduct(ProductDto productDto)  {
        Optional<Product> product=productDao.findById(productDto.getProductId());
        if(product.isPresent()){
            Product product1=new Product();
            product1.setProductId(productDto.getProductId());
            product1.setProductName(productDto.getProductName());
            product1.setProductPrice(productDto.getProductPrice());
            product1.setProductExpiryDate(productDto.getProductExpiryDate());
            product1.setMinQuantity(productDto.getMinQuantity());
            product1.setQuantity(productDto.getQuantity());
            productDao.save(product1);
        }

    }
    public void modifiedQuantityOfTheProduct(Integer productId,Integer quantity) {

        Optional<Product> product=productDao.findById(productId);
        if(product.isPresent()){
            product.get().setQuantity(quantity);
            productDao.save(product.get());
        }
    }


    @Override
    public void deleteProductsBYid(Integer productId) {
        Optional<Product> product=productDao.findById(productId);
        if(product.isPresent()){
            productDao.delete(product.get());
        }
    }

    public List<ProductDto> productPack(Integer [] productIds) {
        List<ProductDto> productDtoList = productDao.findAllById(Arrays.asList(productIds)).stream().map(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setProductPrice(product.getProductPrice());
            productDto.setProductExpiryDate(product.getProductExpiryDate());
            productDto.setMinQuantity(product.getMinQuantity());
            productDto.setQuantity(product.getQuantity());
            return productDto;
        }).collect(Collectors.toList());
        return productDtoList;
    }


}
