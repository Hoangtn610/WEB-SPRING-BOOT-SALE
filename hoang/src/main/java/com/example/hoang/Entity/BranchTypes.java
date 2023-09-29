package com.example.hoang.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "branch_type")
public class BranchTypes {
    @Id
    @Column(name = "BRANCH_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchTypeID;
    @Column(name="BRANCH_TYPE_NAME")
    private String branchTypeName;
}
