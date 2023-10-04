package com.example.hoang.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "branch_type")
public class BranchTypes {
    @Id
    @Column(name = "BRANCH_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long branchTypeID;
    @Column(name="BRANCH_TYPE_NAME")
    private String branchTypeName;

    public BranchTypes(Long branchTypeID, String branchTypeName) {
        this.branchTypeID = branchTypeID;
        this.branchTypeName = branchTypeName;
    }

    public BranchTypes() {

    }

    public Long getBranchTypeID() {
        return branchTypeID;
    }

    public void setBranchTypeID(Long branchTypeID) {
        this.branchTypeID = branchTypeID;
    }

    public String getBranchTypeName() {
        return branchTypeName;
    }

    public void setBranchTypeName(String branchTypeName) {
        this.branchTypeName = branchTypeName;
    }
}
