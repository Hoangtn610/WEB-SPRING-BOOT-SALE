package com.example.hoang.Service;

import com.example.hoang.DTO.BranchAndType;
import com.example.hoang.Entity.Product;
import com.example.hoang.Repository.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository pr;

    public void getMenuProductPage(){
        List<BranchAndType> menuList = new ArrayList<>();
        Product p = new Product();
        List<Object[]> hoang = new ArrayList<>();
//        menuList = pr.GetBranchNameAndProductType();
        hoang = pr.gethoang();
//        p = pr.findByProductID(1L);
        //return menuList;
    }

}
