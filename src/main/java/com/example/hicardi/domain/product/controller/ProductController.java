package com.example.hicardi.domain.product.controller;

import com.example.hicardi.domain.product.dto.*;
import com.example.hicardi.domain.product.service.DemoProductService;
import com.example.hicardi.domain.product.service.ProductService;
import com.example.hicardi.global.S3Service;
import com.example.hicardi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final DemoProductService demoProductService;
    private final ProductService productService;
    private final S3Service s3Service;


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

    //이미지 등록
    @PostMapping("/image")
    public BaseResponseDto<?> uploadImage(
            @RequestPart MultipartFile file
    ){
        return new BaseResponseDto<>(s3Service.uploadImage(file, "product_image"));
    }

    //동영상 등록
    @PostMapping("/video")
    public BaseResponseDto<?> uploadVideo(
            @RequestPart MultipartFile file
    ){
        return new BaseResponseDto<>(s3Service.uploadVideo(file, "product_video"));
    }

    /*
    //이미지 여러개 등록
    @PostMapping("/images")
    public BaseResponseDto<?> uploadImages(
            @RequestPart("files") List<MultipartFile> files
    ){
        List<String> uploadedFileUrls = new ArrayList<>();

        for (MultipartFile file : files) {
            String uploadedFileUrl = s3Service.uploadImage(file, "product_test");
            uploadedFileUrls.add(uploadedFileUrl);
        }

        //업로드된 파일 URL 목록을 응답으로 반환
        return new BaseResponseDto<>(uploadedFileUrls);
    }

     */
}
