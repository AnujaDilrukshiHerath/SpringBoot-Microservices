package com.example.demo.service;

import com.example.demo.VO.Products;
import com.example.demo.VO.ResponeTemplateVO;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserDao userDao;
    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    public UserServiceImpl(UserDao userDao, RestTemplateBuilder restTemplate) {
        this.userDao = userDao;
        this.restTemplate = restTemplate.build();
    }




    @Override
    public void addUser(UserDto userDto) {
        User user=new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUserAddress(userDto.getUserAddress());
        userDao.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList=userDao.findAll();
       return userList.stream().map(user ->{
           UserDto userDto=new UserDto();
           userDto.setUserId(user.getUserId());
           userDto.setUserName(user.getUserName());
           userDto.setPhoneNumber(user.getPhoneNumber());
           userDto.setUserAddress(user.getUserAddress());
           return userDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUserAddress(userDto.getUserAddress());
        userDao.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> byId = userDao.findById(id);
        if (byId.isPresent()){
            userDao.delete(byId.get());
        }
    }

    public ResponeTemplateVO getUserWithCartId(Integer userId) {
        ResponeTemplateVO responeTemplateVO=new ResponeTemplateVO();
       User user=userDao.findByUserId(userId);

//CART
       String url="http://localhost:8081/cart/getCart/"+userId;
       String url1="http://localhost:8080/products/"+userId;
       Products products=restTemplate.getForObject(url1,Products.class);
        Cart cart=restTemplate.getForObject(url,Cart.class);
        responeTemplateVO.setCart(cart);
        responeTemplateVO.setProducts(products);

//        String url="http://localhost:8081/cart/getCartProduct/1";
//        CartHasProduct cartHasProduct=restTemplate.getForObject(url,CartHasProduct.class);
//        responeTemplateVO.setCartHasProduct(cartHasProduct);
        // responeTemplateVO.setCart(cart);
        responeTemplateVO.setUser(user);

        return responeTemplateVO;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        Optional<User> user=userDao.findById(userId);
// Optional<Cart> cart=cartRepository.findById();
        if(user.isPresent()) {
// UserDto userDto=new UserDto();
            Integer userIdget=user.get().getUserId();
            String username=user.get().getUserName();
            Integer pn=user.get().getPhoneNumber();
            String userAddress=user.get().getUserAddress();

            return new UserDto(userIdget,username,pn,userAddress);
        }
        return null;
    }

//    public ResponeTemplateVO getproctwithCart(Integer id) {
//        ResponeTemplateVO responeTemplateVO=new ResponeTemplateVO();
//        User user=userDao.findByUserId(id);
//
//        String url="http://localhost:8080/products/productId/2";
//        Products products=restTemplate.getForObject(url, Products.class);
//
//        responeTemplateVO.setUser(user);
//        responeTemplateVO.setProducts(products);
//        return responeTemplateVO;
//    }
}

