package com.example.hicardi.domain.product.dto;

import com.example.hicardi.domain.product.entity.Product;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductDto {
    private Long productId;
    private String title;
    private String content;
    private int price;
    private String imageUrl; //productImage 중 대표 이미지

}
