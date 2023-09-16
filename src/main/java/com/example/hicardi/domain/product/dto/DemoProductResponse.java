package com.example.hicardi.domain.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoProductResponse {

    private Long demoId;

    public DemoProductResponse(Long demoId) {
        this.demoId = demoId;
    }
}
