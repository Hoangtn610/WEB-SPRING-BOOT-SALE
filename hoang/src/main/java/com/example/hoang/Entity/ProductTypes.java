package com.example.hoang.Entity;

import jakarta.persistence.*;

@Table(name = "product_type")
@Entity
public class ProductTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_TYPE_ID")
    private Long productTypeId;
    @Column(name = "PRODUCT_TYPE_NAME")
    private String productTypeName;

    public ProductTypes(long l, String name) {
        this.productTypeId = l;
        this.productTypeName =name;
    }

    public ProductTypes() {

    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }
}
