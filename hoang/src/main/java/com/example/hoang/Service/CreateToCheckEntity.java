package com.example.hoang.Service;

import com.example.hoang.Entity.BrandTypes;
import com.example.hoang.Entity.Product;
import com.example.hoang.Repository.Product.BranchTypeRepository;
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
        List<BrandTypes> list = new ArrayList<BrandTypes>();
        list.add(new BrandTypes(1L,"Nike"));
        list.add(new BrandTypes(2L,"Adidas"));
        list.add(new BrandTypes(3L,"Janus"));
        list.add(new BrandTypes(4L,"OEM"));
        list.add(new BrandTypes(5L,"Kappa"));
        list.add(new BrandTypes(6L,"Puma"));
        list.add(new BrandTypes(7L,"Molten"));
        list.add(new BrandTypes(8L,"Động lực"));
        list.add(new BrandTypes(9L,"Akapro"));
        list.add(new BrandTypes(10L,"Umbro"));
        list.add(new BrandTypes(11L,"Pelada"));
        list.add(new BrandTypes(12L,"Mizuno"));
        list.add(new BrandTypes(13L,"Joga"));
        list.add(new BrandTypes(14L,"Cramer"));
        list.add(new BrandTypes(15L,"Premier Sock Tape"));
        list.add(new BrandTypes(16L,"Meister Elite"));
        list.add(new BrandTypes(17L,"Kamito"));
        list.add(new BrandTypes(18L,"AKKA"));
        list.add(new BrandTypes(19L,"Athletico"));
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
