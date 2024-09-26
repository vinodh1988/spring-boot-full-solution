package com.bootapps.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bootapps.entitities.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{
     public Product findByProductno(Integer productno);
    
   
     @Query("SELECT p FROM Product p where p.price between :min and :max")
     public List<Product> findByPriceRange(@Param("min")int min, @Param("max")int max);
}
