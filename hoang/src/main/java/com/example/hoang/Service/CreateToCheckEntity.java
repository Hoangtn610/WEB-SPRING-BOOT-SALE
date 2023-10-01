package com.example.hoang.Service;

import com.example.hoang.Entity.BranchTypes;
import com.example.hoang.Entity.Product;
import com.example.hoang.Entity.BranchTypes;
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
//    @Autowired
//    public ProductRepository pr;

    public void check(){
        List<BranchTypes> list = new ArrayList<BranchTypes>();
        list.add(new BranchTypes(1L,"Nike"));
        list.add(new BranchTypes(2L,"Adidas"));
        list.add(new BranchTypes(3L,"Janus"));
        list.add(new BranchTypes(4L,"OEM"));
        list.add(new BranchTypes(5L,"Kappa"));
        list.add(new BranchTypes(6L,"Puma"));
        list.add(new BranchTypes(7L,"Molten"));
        list.add(new BranchTypes(8L,"Động lực"));
        list.add(new BranchTypes(9L,"Akapro"));
        list.add(new BranchTypes(10L,"Umbro"));
        list.add(new BranchTypes(11L,"Pelada"));
        list.add(new BranchTypes(12L,"Mizuno"));
        list.add(new BranchTypes(13L,"Joga"));
        list.add(new BranchTypes(14L,"Cramer"));
        list.add(new BranchTypes(15L,"Premier Sock Tape"));
        list.add(new BranchTypes(16L,"Meister Elite"));
        list.add(new BranchTypes(17L,"Kamito"));
        list.add(new BranchTypes(18L,"AKKA"));
        list.add(new BranchTypes(19L,"Athletico"));
        Product p = new Product();
//        btr.saveAll(list);
//        p.setSale(0);
//        p.setQuantity(1000);
//        p.setSold(0);
//        //-------------------------
//        p.setPrice(50);
//        p.setProductName("Nike Tiempo React 9 Pro TF");
//        p.setMadeIn("America");
//        p.setImagePath("https://imgs.search.brave.com/TqDl3314oaTrpU35ywTGeB0gdI1pSLQg0Soknon7fOA/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9wb3Mu/bnZuY2RuLm5ldC9i/MGI3MTctMjYxODEv/cHMvMjAyMzAxMzFf/eDZBUWo3TjRkZFQ2/cEpSay5qcGc");
//        p.setProductType(1);
//        p.setProductBranch(1);
//        pr.save(p);
//        List<BranchTypes> list = new ArrayList<BranchTypes>();
//        List<BranchTypes> list1 = new ArrayList<BranchTypes>();
//        list =  ptr.findAll();
//        list1 =  btr.findAll();
    }
}
