package com.example.hoang.Repository.Product;

import com.example.hoang.Entity.ProductTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypes,Long> {
    @Override
    <S extends ProductTypes> S save(S entity);

    @Override
    <S extends ProductTypes> List<S> saveAll(Iterable<S> entities);

    @Override
    List<ProductTypes> findAll();

    ProductTypes getProductTypesByProductTypeId(Long ProductTypeID);
}
