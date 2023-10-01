package com.example.hoang.Service;

import com.example.hoang.Entity.Product;
import com.example.hoang.Repository.Product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public ProductRepository pr;

    public void getMenuProductPage(){
        List<Product> menuList = new ArrayList<>();
        menuList = pr.GetBranchNameAndProductType();
        int i = 0;
        i++;
        //return menuList;
    }
}
