package com.example.hoang.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class BranchAndType {
    private int productType;
    private int productBranch;

    public BranchAndType(int productType, int productBranch) {
        this.productType = productType;
        this.productBranch = productBranch;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getProductBranch() {
        return productBranch;
    }

    public void setProductBranch(int productBranch) {
        this.productBranch = productBranch;
    }
}
