package com.bootapps.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapps.entitities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
     public Product findByProductNo(Integer productno);
}
