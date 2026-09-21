package com.example.demo.ProductStuff.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String  category;
    private String imageURL;
    private BigDecimal price;
    private Integer stockquantity;
    private Boolean active ;

}
