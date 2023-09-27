package com.example.hoang.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private String productName;
    private String URLImage;
    private float price;
    private String descProd;
    private Long sold;
}
