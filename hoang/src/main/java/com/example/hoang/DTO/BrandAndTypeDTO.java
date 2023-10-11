package com.example.hoang.DTO;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class BrandAndTypeDTO extends Object {
    private HashMap<Long,String> productType;
    private List<HashMap<Long,String>> productBrand;

    public BrandAndTypeDTO(HashMap<Long, String> productType, List<HashMap<Long, String>> productBranch) {
        this.productType = productType;
        this.productBrand = productBranch;
    }

    public HashMap<Long, String> getProductType() {
        return productType;
    }

    public void setProductType(HashMap<Long, String> productType) {
        this.productType = productType;
    }

    public List<HashMap<Long, String>> getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(List<HashMap<Long, String>> productBrand) {
        this.productBrand = productBrand;
    }

    public BrandAndTypeDTO() {
    }
}
