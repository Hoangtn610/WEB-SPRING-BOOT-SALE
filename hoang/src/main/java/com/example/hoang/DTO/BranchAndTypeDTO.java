package com.example.hoang.DTO;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class BranchAndTypeDTO extends Object {
    private HashMap<Long,String> productType;
    private List<HashMap<Long,String>> productBranch;

    public BranchAndTypeDTO(HashMap<Long, String> productType, List<HashMap<Long, String>> productBranch) {
        this.productType = productType;
        this.productBranch = productBranch;
    }

    public HashMap<Long, String> getProductType() {
        return productType;
    }

    public void setProductType(HashMap<Long, String> productType) {
        this.productType = productType;
    }

    public List<HashMap<Long, String>> getProductBranch() {
        return productBranch;
    }

    public void setProductBranch(List<HashMap<Long, String>> productBranch) {
        this.productBranch = productBranch;
    }

    public BranchAndTypeDTO() {
    }
}
