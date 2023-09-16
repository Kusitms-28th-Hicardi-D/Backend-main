package com.example.hicardi.domain.product.controller;

import com.example.hicardi.domain.product.dto.DemoProductRequest;
import com.example.hicardi.domain.product.dto.DemoProductResponse;
import com.example.hicardi.domain.product.dto.ProductRequest;
import com.example.hicardi.domain.product.dto.ProductResponse;
import com.example.hicardi.domain.product.service.DemoProductService;
import com.example.hicardi.domain.product.service.ProductService;
import com.example.hicardi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final DemoProductService demoProductService;
    private final ProductService productService;

    // 데모요청 API
    @PostMapping("/demo")
    public ResponseEntity<BaseResponseDto<DemoProductResponse>> createDemoProduct(@RequestBody DemoProductRequest demoProductRequest) {
        BaseResponseDto<DemoProductResponse> response = demoProductService.createDemoProduct(demoProductRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("")
    public ResponseEntity<BaseResponseDto<ProductResponse>> createProduct(@RequestBody ProductRequest productRequest) {
        BaseResponseDto<ProductResponse> response = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
