package com.example.hoang.Repository;

import com.example.hoang.Entity.ProductPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPicRepository extends JpaRepository<ProductPicture,Long> {

}
