package com.example.demo.service.impl;


import com.example.demo.ResponseTemplete.ResponseTempleteCartHasProduct;
import com.example.demo.dao.CartHasProductRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dto.CartHasProductDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartHasProduct;
import com.example.demo.entity.Product;
import com.example.demo.service.CartHasProductService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CartHasProductImpl implements CartHasProductService {

    @Autowired
    private CartHasProductRepository cartHasProductRepository;

    @Autowired
    private CartRepository cartRepository;

   /* @Autowired
    private ProductRepository productRepository;*/

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    public CartHasProductImpl(CartHasProductRepository cartHasProductRepository,/* CartRepository cartRepository, ProductRepository productRepository,*/ RestTemplate restTemplate) {
        this.cartHasProductRepository = cartHasProductRepository;
        //this.cartRepository = cartRepository;
        this.restTemplate = restTemplate;
        //this.productRepository = productRepository;
    }

    public List<CartHasProduct> getCartProducts() {

        return cartHasProductRepository.findAll();
    }
    /*@Override

    public List<ProductDto> getAllProducts() {
        return productDao.findAll().stream().map(Product -> {

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
*/

    public CartHasProductDto getCartProduct(int cartProductId) throws NotFoundException {
        Optional<CartHasProduct> cartHasProduct = cartHasProductRepository.findById(cartProductId);
        if (!cartHasProduct.isPresent()) {
            throw new NotFoundException("Cart product not found!");
        }
        CartHasProductDto cartHasProductDto = new CartHasProductDto();
        cartHasProductDto.setCartHasProductId(cartHasProduct.get().getCartHasProductId());
        cartHasProductDto.setQuantity(cartHasProduct.get().getQuantity());
        cartHasProductDto.setProduct_productId(cartHasProduct.get().getProduct_productId());
        cartHasProductDto.setCartId(cartHasProduct.get().getCartId());

        return cartHasProductDto;
    }


   public String addCartProduct(CartHasProductDto cartHasProductDto) {
        CartHasProduct cartHasProduct = new CartHasProduct();
        cartHasProduct.setCartHasProductId(cartHasProductDto.getCartHasProductId());
        cartHasProduct.setQuantity(cartHasProductDto.getQuantity());

        Cart cart =new Cart();
        Product product=new Product();

        cartHasProduct.setProduct_productId(cartHasProductDto.getProduct_productId());
        cartHasProduct.setCartId(cartHasProductDto.getProduct_productId());
        //User user1=userRepository.save(user);

        cartHasProductRepository.save(cartHasProduct);
        return "Successfully saved the cart product";
    }

//undo the comment

    public void deleteCartProduct(Integer cartHasProductId) {
        Optional<CartHasProduct> cartHasProduct = cartHasProductRepository.findById(cartHasProductId);
        if (cartHasProduct.isPresent()) {
            cartHasProductRepository.delete(cartHasProduct.get());
        }
    }

    public CartHasProduct updateCartProduct(CartHasProductDto cartHasProductDto) {
        CartHasProduct cartHasProduct = new CartHasProduct();
        cartHasProduct.setCartHasProductId(cartHasProduct.getCartHasProductId());
        cartHasProductRepository.save(cartHasProduct);
        return cartHasProduct;
    }


  /*  public ResponseTempleteCartHasProduct getCartHasProduct(Integer cartHasProductId) {
        ResponseTempleteCartHasProduct ab = new ResponseTempleteCartHasProduct();
        CartHasProduct cartHasProduct=cartHasProductRepository.findByCartProductId(cartHasProductId);

        String photoUrl = "http://localhost:8082/product/";
        Product product=
                restTemplate.getForObject( photoUrl, Product.class);
        ab.setProduct(product);

        ab.setCartHasProduct(cartHasProduct);
        return ab;
    }*/


/*
   public ResponseTempleteCartHasProduct getCartHasProduct(Integer cartHasProductId) {
   ResponseTempleteCartHasProduct ab = new ResponseTempleteCartHasProduct();
        CartHasProduct cartHasProduct = cartHasProductRepository.findByCartProductId(cartHasProductId);
//CART
        String url="http://localhost:8081/cart/getCart/"+cartHasProductId;
        String url1="http://localhost:8080/products/"+cartHasProductId;
        Product products=restTemplate.getForObject(url1, Product.class);
        Cart cart=restTemplate.getForObject(url,Cart.class);
        ab.setCart(cart);
        ab.setProduct(products);
        ab.setCartHasProduct(cartHasProduct);

        return ab;
    }*/
}