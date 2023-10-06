package com.example.hoang.Service;

import com.example.hoang.DTO.BranchAndType;
import com.example.hoang.Entity.BranchTypes;
import com.example.hoang.Entity.Product;
import com.example.hoang.Entity.ProductTypes;
import com.example.hoang.Repository.Product.BranchTypeRepository;
import com.example.hoang.Repository.Product.ProductRepository;
import com.example.hoang.Repository.Product.ProductTypeRepository;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository pr;
    @Autowired
    public ProductTypeRepository ptr;
    @Autowired
    public BranchTypeRepository btr;
    private Object bien;

    public List<BranchAndType> getMenuProductPage() {
        //query all branch and type
        List<Object[]> brandAndType = new ArrayList<>();
        brandAndType = pr.GetBranchNameAndProductType();
        List<ProductTypes> ptList = ptr.findAll();
        List<BranchTypes> bTList = btr.findAll();
        List<BranchAndType> branchAndTypesList = new ArrayList<>();
        for (ProductTypes pt : ptList) {
            List<HashMap<Long, String>> listTamBraType = new ArrayList<>();
            HashMap<Long, String> tamPType = new HashMap<>();
            for (int i = 0; i < brandAndType.size(); i++) {
                if (pt.getProductTypeId() == convertToLong(brandAndType.get(i)[1])) {
                    if (tamPType.isEmpty()) {
                        tamPType.put(pt.getProductTypeId(), pt.getProductTypeName());
                    }
                    for (BranchTypes bt1 : bTList) {
                        if (bt1.getBranchTypeID().compareTo(convertToLong(brandAndType.get(i)[0])) == 0) {
                            HashMap<Long, String> tamBranType = new HashMap<>();
                            tamBranType.put(bt1.getBranchTypeID(), bt1.getBranchTypeName());
                            listTamBraType.add(tamBranType);
                            break;
                        }
                    }
                }
            }
            BranchAndType bat1 = new BranchAndType(tamPType, listTamBraType);
            branchAndTypesList.add(bat1);
        }
        return branchAndTypesList;
        //branchAndTypesList.size();
    }
    public static Long convertToLong(Object o){
        String stringToConvert = String.valueOf(o);
        Long convertedLong = Long.parseLong(stringToConvert);
        return convertedLong;

    }
}
