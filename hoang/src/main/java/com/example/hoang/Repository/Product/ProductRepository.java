package com.example.hoang.Repository.Product;

import com.example.hoang.DTO.BranchAndType;
import com.example.hoang.Entity.Product;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    List<Product> findAll();
//    @Query(value = "select "+
//            " new com.example.hoang.DTO.BranchAndType(Product.productType,Product.productBranch) FROM Product p GROUP BY p.productBranch,p.productType")
//    List<BranchAndType> GetBranchNameAndProductType();
    @Query("SELECT p.productBranch,p.productType FROM Product p GROUP BY p.productBranch,p.productType")
    List<Object[]> GetBranchNameAndProductType();

//    Product findByProductID(Long id);

}
