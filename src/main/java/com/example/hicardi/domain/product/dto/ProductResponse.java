package com.example.hicardi.domain.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long productId;

    public ProductResponse(Long productId) {
        this.productId = productId;
    }
}
