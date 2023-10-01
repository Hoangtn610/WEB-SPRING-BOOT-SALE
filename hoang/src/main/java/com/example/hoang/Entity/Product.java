package com.example.hoang.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="PRICE")
    private double price;
    @Column(name="SALE")
    private int sale;
    @Column(name="QUANTITY")
    private int quantity;
    @Column(name="SOLD")
    private int sold;
    @Column(name="MADE_IN")
    private String madeIn;
    @Column(name="IMAGE_PATH")
    private String imagePath;
    @Column(name="PRODUCT_TYPE")
    private int productType;
    @Column(name="PRODUCT_BRANCH")
    private int productBranch;

    public Product(String productName, double price, int sale, int quantity, int sold, String madeIn, String imagePath, int productType, int productBranch) {
        this.productName = productName;
        this.price = price;
        this.sale = sale;
        this.quantity = quantity;
        this.sold = sold;
        this.madeIn = madeIn;
        this.imagePath = imagePath;
        this.productType = productType;
        this.productBranch = productBranch;
    }
    public Product(){}
}
