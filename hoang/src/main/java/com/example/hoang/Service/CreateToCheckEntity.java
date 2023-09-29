package com.example.hoang.Service;

import com.example.hoang.Entity.BranchTypes;
import com.example.hoang.Entity.Product;
import com.example.hoang.Entity.ProductTypes;
import com.example.hoang.Repository.Product.BranchTypeRepository;
import com.example.hoang.Repository.Product.ProductRepository;
import com.example.hoang.Repository.Product.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CreateToCheckEntity {
    @Autowired
    public BranchTypeRepository btr;
    @Autowired
    public ProductRepository pr;

    public void check(){
//        ArrayList<ProductTypes> list = new ArrayList<ProductTypes>();
//        list.add(new ProductTypes(1L,"Nike"));
//        list.add(new ProductTypes(2L,"Adidas"));
//        list.add(new ProductTypes(3L,"Shin pad"));
//        list.add(new ProductTypes(4L,"OEM"));
//        list.add(new ProductTypes(5L,"Kappa"));
//        list.add(new ProductTypes(6L,"Puma"));
//        list.add(new ProductTypes(7L,"Molten"));
//        list.add(new ProductTypes(8L,"Động lực"));
//        list.add(new ProductTypes(9L,"Akapro"));
//        list.add(new ProductTypes(10L,"Umbro"));
//        list.add(new ProductTypes(11L,"Pelada"));
//        list.add(new ProductTypes(12L,"Mizuno"));
//        list.add(new ProductTypes(13L,"Yoga"));
//        list.add(new ProductTypes(14L,"Cramer"));
//        list.add(new ProductTypes(15L,"Premier Sock Tape"));
//        list.add(new ProductTypes(16L,"Meister Elite"));
//        list.add(new ProductTypes(17L,"Kamito"));
        Product p = new Product();

        p.setSale(0);
        p.setQuantity(1000);
        p.setSold(0);
        //-------------------------
        p.setPrice(50);
        p.setProductName("Nike Tiempo React 9 Pro TF");
        p.setMadeIn("America");
        p.setImagePath("https://imgs.search.brave.com/TqDl3314oaTrpU35ywTGeB0gdI1pSLQg0Soknon7fOA/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9wb3Mu/bnZuY2RuLm5ldC9i/MGI3MTctMjYxODEv/cHMvMjAyMzAxMzFf/eDZBUWo3TjRkZFQ2/cEpSay5qcGc");
        p.setProductType(1);
        p.setProductBranch(1);
        pr.save(p);
//        List<ProductTypes> list = new ArrayList<ProductTypes>();
//        List<BranchTypes> list1 = new ArrayList<BranchTypes>();
//        list =  ptr.findAll();
//        list1 =  btr.findAll();
    }
}
