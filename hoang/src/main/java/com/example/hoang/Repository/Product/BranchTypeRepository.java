package com.example.hoang.Repository.Product;

import com.example.hoang.Entity.BranchTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchTypeRepository  extends JpaRepository<BranchTypes,Long> {
    public BranchTypes getBranchTypesByBranchTypeID(Long branchTypeID);
    public List<BranchTypes> findAllBy();

    @Override
    <S extends BranchTypes> List<S> saveAll(Iterable<S> entities);
}
