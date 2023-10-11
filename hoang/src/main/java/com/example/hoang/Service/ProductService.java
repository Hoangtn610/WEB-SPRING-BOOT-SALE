package com.example.hoang.Service;

import com.example.hoang.DTO.BrandAndTypeDTO;
import com.example.hoang.Entity.BrandTypes;
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

import static com.example.hoang.Utils.CommonFuntion.convertLongToInt;
import static com.example.hoang.Utils.CommonFuntion.convertToLong;

@Service
public class ProductService {
    @Autowired
    public ProductRepository pr;
    @Autowired
    public ProductTypeRepository ptr;
    @Autowired
    public BranchTypeRepository btr;

    public List<BrandAndTypeDTO> getMenuProductPage() {
        //query all branch and type
        List<Object[]> brandAndType = new ArrayList<>();
        brandAndType = pr.GetBrandNameAndProductType();
        List<ProductTypes> ptList = ptr.findAll();
        List<BrandTypes> bTList = btr.findAll();
        List<BrandAndTypeDTO> branchAndTypesList = new ArrayList<>();
        for (ProductTypes pt : ptList) {
            List<HashMap<Long, String>> listTamBraType = new ArrayList<>();
            HashMap<Long, String> tamPType = new HashMap<>();
            for (int i = 0; i < brandAndType.size(); i++) {
                if (pt.getProductTypeId() == convertToLong(brandAndType.get(i)[1])) {
                    if (tamPType.isEmpty()) {
                        tamPType.put(pt.getProductTypeId(), pt.getProductTypeName());
                    }
                    for (BrandTypes bt1 : bTList) {
                        if (bt1.getBrandTypeID().compareTo(convertToLong(brandAndType.get(i)[0])) == 0) {
                            HashMap<Long, String> tamBranType = new HashMap<>();
                            tamBranType.put(bt1.getBrandTypeID(), bt1.getBrandTypeName());
                            listTamBraType.add(tamBranType);
                            break;
                        }
                    }
                }
            }
            BrandAndTypeDTO bat1 = new BrandAndTypeDTO(tamPType, listTamBraType);
            branchAndTypesList.add(bat1);
        }
        return branchAndTypesList;
        //branchAndTypesList.size();
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
            pdList = pr.getProductsByProductTypeAndAndProductBrand(productTypeID,productBrandID);
        }
        return pdList;
    }

    public String showProductTittle(String pdTID, String bTid){
        if(pdTID == null && bTid == null){
            return "BestSeller";
        } else if (pdTID != null && bTid == null) {
            String productTypeName;
            productTypeName = ptr.getProductTypesByProductTypeId(convertToLong(pdTID)).getProductTypeName();
            return productTypeName;
        } else if (pdTID != null && bTid != null) {
            String productTypeName;
            String brandType;
            productTypeName = ptr.getProductTypesByProductTypeId(convertToLong(pdTID)).getProductTypeName();
            brandType = btr.getBranchTypesByBrandTypeID(convertToLong(bTid)).getBrandTypeName();
            return productTypeName + "/" + brandType;
        } else {
            return "";
        }
    }
}
