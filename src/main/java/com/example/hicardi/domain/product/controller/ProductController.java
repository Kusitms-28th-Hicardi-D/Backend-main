package com.example.hicardi.domain.product.controller;

import com.example.hicardi.domain.product.dto.*;
import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.product.service.DemoProductService;
import com.example.hicardi.domain.product.service.ProductService;
import com.example.hicardi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final DemoProductService demoProductService;
    private final ProductService productService;

    //데모요청 API
    @PostMapping("/demo")
    public ResponseEntity<BaseResponseDto<DemoProductResponse>> createDemoProduct(@RequestBody DemoProductRequest demoProductRequest) {
        BaseResponseDto<DemoProductResponse> response = demoProductService.createDemoProduct(demoProductRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //상품등록 API
    @PostMapping("")
    public ResponseEntity<BaseResponseDto<ProductResponse>> createProduct(@RequestBody ProductRequest productRequest) {
        BaseResponseDto<ProductResponse> response = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //카테고리별 상품 전체조회 API
    @GetMapping("/list")
    public ResponseEntity<BaseResponseDto<AllProductResponse>> getProductList(@RequestParam(name = "category", defaultValue = "all") String category) {
        BaseResponseDto<AllProductResponse> response = productService.getProductList(category);

        return ResponseEntity.ok(response);
    }

    //productId별 상품 조회 API
    @GetMapping("/list/{id}")
    public ResponseEntity<BaseResponseDto<OneProductDto>> getProductById(@PathVariable Long id) {
        BaseResponseDto<OneProductDto> response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }
}
