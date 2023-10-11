package com.example.hoang.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "branch_type")
public class BrandTypes {
    @Id
    @Column(name = "BRANCH_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long brandTypeID;
    @Column(name="BRANCH_TYPE_NAME")
    private String brandTypeName;

    public BrandTypes(Long brandTypeID, String brandTypeName) {
        this.brandTypeID = brandTypeID;
        this.brandTypeName = brandTypeName;
    }

    public BrandTypes() {

    }

    public Long getBrandTypeID() {
        return brandTypeID;
    }

    public void setBrandTypeID(Long branchTypeID) {
        this.brandTypeID = branchTypeID;
    }

    public String getBrandTypeName() {
        return brandTypeName;
    }

    public void setBrandTypeName(String branchTypeName) {
        this.brandTypeName = branchTypeName;
    }
}
