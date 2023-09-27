package com.example.hoang.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_picture")
public class ProductPicture {
    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    @Column(name="URL1")
    private String url1;
    @Column(name="URL2")
    private String url2;
    @Column(name="URL3")
    private String url3;
}
