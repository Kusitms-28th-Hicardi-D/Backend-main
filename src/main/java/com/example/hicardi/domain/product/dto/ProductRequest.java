package com.example.hicardi.domain.product.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ProductRequest {
    private String title;
    private String engName;
    private String content;
    private int price;
    private List<ProductOptionRequest> options;
    private List<ProductImageRequest> productImg;
    private String detailImg;
    private String category;
}

