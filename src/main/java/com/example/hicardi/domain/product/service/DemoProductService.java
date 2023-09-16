package com.example.hicardi.domain.product.service;

import com.example.hicardi.domain.intro.dto.IntroResponse;
import com.example.hicardi.domain.product.dto.DemoProductRequest;
import com.example.hicardi.domain.product.dto.DemoProductResponse;
import com.example.hicardi.domain.product.entity.DemoProduct;
import com.example.hicardi.domain.product.repository.DemoProductRepository;
import com.example.hicardi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DemoProductService {
    private final DemoProductRepository demoProductRepository;

    @Transactional
    public BaseResponseDto<DemoProductResponse> createDemoProduct(DemoProductRequest demoProductRequest) {
        DemoProduct demoProduct = DemoProduct.createDemoProduct(demoProductRequest);
        demoProductRepository.save(demoProduct);
        Long demoId = demoProduct.getId();

        // Response 생성
        DemoProductResponse demoProductResponse = new DemoProductResponse(demoId);
        BaseResponseDto<DemoProductResponse> response = new BaseResponseDto<DemoProductResponse>(
                HttpStatus.CREATED.value(),
                true,
                "DemoProduct 생성 API",
                demoProductResponse
        );

        return response;
    }
}
