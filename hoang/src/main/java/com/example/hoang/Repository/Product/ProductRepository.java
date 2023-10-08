package com.example.hoang.Repository.Product;

import com.example.hoang.Entity.Product;
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

    @Query("SELECT p FROM Product p ORDER BY p.sold desc LIMIT 20")
    List<Product> getProductBestSeller();
    List<Product> findTop20ByOrderBySoldDesc();

    List<Product> getProductsByProductType(int productType);
    List<Product> getProductsByProductTypeAndProductBranch(Long productType, Long productBrand);
}
