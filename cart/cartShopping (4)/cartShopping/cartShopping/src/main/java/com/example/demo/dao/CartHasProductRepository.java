package com.example.demo.dao;


import com.example.demo.entity.CartHasProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartHasProductRepository extends JpaRepository<CartHasProduct,Integer> {
    List<CartHasProduct> findByCartId(Integer cartId);

    //List<CartHasProduct> findByCart_CartId(Integer cartId);
    //CartHasProduct findByCartProductId(Integer cartHasProductId);



}
