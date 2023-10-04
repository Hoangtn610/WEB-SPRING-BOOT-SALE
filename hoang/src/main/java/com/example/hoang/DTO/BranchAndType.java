package com.example.hoang.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Data
public class BranchAndType extends Object {
    private HashMap<Long,String> productType;
    private List<HashMap<Long,String>> productBranch;

    public BranchAndType(HashMap<Long, String> productType, List<HashMap<Long, String>> productBranch) {
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

    public BranchAndType() {
    }
}
