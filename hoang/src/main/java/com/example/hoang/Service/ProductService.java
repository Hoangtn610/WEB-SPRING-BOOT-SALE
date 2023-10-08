package com.example.hoang.Service;

import com.example.hoang.DTO.BranchAndTypeDTO;
import com.example.hoang.Entity.BranchTypes;
import com.example.hoang.Entity.Product;
import com.example.hoang.Entity.ProductTypes;
import com.example.hoang.Repository.Product.BranchTypeRepository;
import com.example.hoang.Repository.Product.ProductRepository;
import com.example.hoang.Repository.Product.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<BranchAndTypeDTO> getMenuProductPage() {
        //query all branch and type
        List<Object[]> brandAndType = new ArrayList<>();
        brandAndType = pr.GetBranchNameAndProductType();
        List<ProductTypes> ptList = ptr.findAll();
        List<BranchTypes> bTList = btr.findAll();
        List<BranchAndTypeDTO> branchAndTypesList = new ArrayList<>();
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
            BranchAndTypeDTO bat1 = new BranchAndTypeDTO(tamPType, listTamBraType);
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
    public int convertLongToInt(Long value) {
        if (value != null) {
            return value.intValue();
        } else {
            // Handle the case where the Long value is null, or provide a default value if needed.
            return -1; // You can change this to another default value if necessary.
        }
    }

    public List<Product> showRequestProduct (String pdTID, String bTid){
        List<Product> pdList = new ArrayList<>();
        if(pdTID == null && bTid == null){
            pdList = pr.findTop20ByOrderBySoldDesc();
        } else if (pdTID != null && bTid == null) {
           Long productTypeID = convertToLong(pdTID);
            pdList = pr.getProductsByProductType(convertLongToInt(productTypeID));
        } else if (pdTID != null && bTid != null) {
            Long productTypeID = convertToLong(pdTID);
            Long productBrandID = convertToLong(bTid);
            pdList = pr.getProductsByProductTypeAndProductBranch(productTypeID,productBrandID);
        }
        return pdList;
    }
}
