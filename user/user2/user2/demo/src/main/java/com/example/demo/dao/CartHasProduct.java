package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartHasProduct extends JpaRepository<com.example.demo.entity.CartHasProduct,Integer> {
}
