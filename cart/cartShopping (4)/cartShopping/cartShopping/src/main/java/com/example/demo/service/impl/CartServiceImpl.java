package com.example.demo.service.impl;

import com.example.demo.dao.CartHasProductRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.CartDto;
import com.example.demo.ResponseTemplete.ResponseTempleteCart;
import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartHasProduct;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.CartService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CartHasProductRepository cartHasProductRepository;



    @Autowired
    public CartServiceImpl(CartRepository cartRepository,CartHasProductRepository cartHasProductRepository, UserRepository userRepository, RestTemplate restTemplate) {
        this.cartRepository = cartRepository;
        this.restTemplate = restTemplate;
        this.userRepository=userRepository;
        this.cartHasProductRepository=cartHasProductRepository;
    }

    public List<Cart> getCarts() {

        return cartRepository.findAll();
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

    public CartDto getCart(int cartId) throws NotFoundException {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (!cart.isPresent()) {
            throw new NotFoundException("Cart not found!");
        }
        CartDto cartDto = new CartDto();
        cartDto.setCartId(cart.get().getCartId());
        cartDto.setSubTotal(cart.get().getSubTotal());
        cartDto.setUser_userId(cart.get().getUser_userId());
        return cartDto;
    }

    public String addCart(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setSubTotal(cartDto.getSubTotal());
        cart.setCartId(cartDto.getCartId());
        User user = new User();

        //User user1=userRepository.save(user);
        cart.setUser_userId(cartDto.getUser_userId());
        cartRepository.save(cart);
        return "Successfully saved the cart";
    }


    public void deleteCart(Integer cartId) {
        Optional<Cart> cart = cartRepository.findById(cartId);
        if (cart.isPresent()) {
            cartRepository.delete(cart.get());
        }
    }


    public Cart updateCart(CartDto cartGetDto) {
        Cart cart = new Cart();
        cart.setCartId(cart.getCartId());
        cartRepository.save(cart);
        return cart;
    }

  public ResponseTempleteCart getCartProduct(Integer  cartId) {
        ResponseTempleteCart response = new ResponseTempleteCart();
        Cart cart=cartRepository.findByCartId(cartId);
        List<CartHasProduct> cartHasProductList = cartHasProductRepository.findByCartId(cartId);
        List<Integer> cartHasProducts=new ArrayList<>();
      for (CartHasProduct cartHasProduct : cartHasProductList) {

           cartHasProducts.add(cartHasProduct.getProduct_productId());

       }

         String finalString = cartHasProducts.toString().replace("[","").replace("]","").trim();


        String photoUrl = "http://SHOP/products/productPack/"+finalString;
        ProductDto[] productList= restTemplate.getForObject( photoUrl ,ProductDto[].class);

                response.setCart(cart);
                //response.setProduct((ProductDto) productList);
                response.setProductDtoList(Arrays.asList(productList));

        return response;
    }

   /*public Cart saveCart(Cart cart) {
        log.info("inside save cart method of cart Controller");
        return cartRepository.save(cart);
    }*//*

   public Cart findById(Integer cartId) {
        log.info("inside save cart method of cart Controller");
        return cartRepository.findByCartId(cartId);
    }*/
}



