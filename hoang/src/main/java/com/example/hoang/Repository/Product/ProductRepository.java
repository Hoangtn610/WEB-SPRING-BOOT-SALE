package com.example.hoang.Repository.Product;

import com.example.hoang.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    List<Product> findAll();
}
