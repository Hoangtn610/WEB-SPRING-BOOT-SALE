package com.example.hoang.Repository.Product;

import com.example.hoang.Entity.BrandTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchTypeRepository  extends JpaRepository<BrandTypes,Long> {
    public BrandTypes getBranchTypesByBrandTypeID(Long branchTypeID);
    public List<BrandTypes> findAllBy();

    @Override
    <S extends BrandTypes> List<S> saveAll(Iterable<S> entities);
}
