package com.example.hicardi.domain.product.dto;

import com.example.hicardi.domain.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllProductResponse {
    private List<ProductDto> productList;

    public AllProductResponse(List<ProductDto> productDtoList) {
        this.productList = productDtoList;
    }
}
