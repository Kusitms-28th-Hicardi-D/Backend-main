package com.example.hicardi.domain.product.service;

import com.example.hicardi.domain.intro.dto.IntroVideoRequest;
import com.example.hicardi.domain.intro.entity.IntroVideo;
import com.example.hicardi.domain.product.dto.*;
import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.product.entity.ProductImage;
import com.example.hicardi.domain.product.entity.ProductOption;
import com.example.hicardi.domain.product.repository.ProductImageRepository;
import com.example.hicardi.domain.product.repository.ProductOptionRepository;
import com.example.hicardi.domain.product.repository.ProductRepository;
import com.example.hicardi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductOptionRepository productOptionRepository;
    private final ProductImageRepository productImageRepository;

    @Transactional
    public BaseResponseDto<ProductResponse> createProduct (ProductRequest productRequest) {
        //product 생성
        Product product = Product.createProduct(productRequest.getTitle(), productRequest.getEngName(), productRequest.getContent(), productRequest.getPrice(), productRequest.getDetailImg(), productRequest.getCategory());
        productRepository.save(product);
        Long productId = product.getId();

        // ProductImage 목록 생성
        if (productRequest.getProductImg() != null) {
            for (ProductImageRequest imageRequest : productRequest.getProductImg()) {
                ProductImage productImage = ProductImage.createProductImage(imageRequest.getImageDesc(), imageRequest.getImageUrl(), product);
                productImageRepository.save(productImage);
            }
        }

        // ProductOption 목록 생성
       if (productRequest.getOptions() != null) {
           for (ProductOptionRequest optionRequest : productRequest.getOptions()) {
               ProductOption productOption = ProductOption.createProductOption(optionRequest.getName(),optionRequest.getContent(), product);
               System.out.println(productOption.getProduct() + productOption.getName() + productOption.getContent());
               productOptionRepository.save(productOption);
           }
       }

        // Response 생성
        ProductResponse productResponse = new ProductResponse(productId);
        BaseResponseDto<ProductResponse> response = new BaseResponseDto<ProductResponse>(
                HttpStatus.CREATED.value(),
                true,
                "Product 생성 API",
                productResponse
        );

        return response;
    }

    public BaseResponseDto<AllProductResponse> getProductList(String category) {
        List<Product> productList;

        if ("all".equals(category)) {
            productList = productRepository.findAll();
        } else {
            productList = productRepository.findByCategory(category);
        }

        List<ProductDto> productDtoList = new ArrayList<>();

        for (Product product : productList) {
            ProductDto productDto = new ProductDto();
            productDto.setProductId(product.getId());
            productDto.setTitle(product.getTitle());
            productDto.setContent(product.getContent());
            productDto.setPrice(product.getPrice());

            // 대표 이미지 설정 (이미지 URL을 가져오는 로직이 필요)
            //productDto.setImageUrl(productImageRepository.findBy(product));
            List<ProductImage> imageUrl = productImageRepository.findByProduct(product);
            if(imageUrl.size() > 0)
                productDto.setImageUrl(imageUrl.get(0).getImageUrl());

            productDtoList.add(productDto);
        }

        // Response 생성
        AllProductResponse allProductResponse = new AllProductResponse(productDtoList);
        BaseResponseDto<AllProductResponse> response = new BaseResponseDto<AllProductResponse>(
                HttpStatus.OK.value(),
                true,
                "카테고리별 Product 조회 API",
                allProductResponse
        );

        return response;
    }

    public BaseResponseDto<OneProductDto> getProductById(Long id){
        Product product = productRepository.findProductById(id);
        if(product != null){
            OneProductDto oneProductDto = new OneProductDto(product);

            //productOptionRepository에서 productID
            List<ProductOption> productOptionList = productOptionRepository.findByProductId(product.getId());
            List<ProductOptionRequest> productOptionDtoList = new ArrayList<>();
            for (ProductOption productOption : productOptionList) {
                ProductOptionRequest productOptionRequest = new ProductOptionRequest();
                productOptionRequest.setName(productOption.getName());
                productOptionRequest.setContent(productOption.getContent());

                productOptionDtoList.add(productOptionRequest);
            }
            oneProductDto.setOptionList(productOptionDtoList);

            //productImageRepository에서 productID
            List<ProductImage> productImageList = productImageRepository.findByProductId(product.getId());
            List<ProductImageRequest> productImageDtoList = new ArrayList<>();
            for (ProductImage productImage : productImageList){
                ProductImageRequest productImageRequest = new ProductImageRequest();
                productImageRequest.setImageDesc(productImage.getImageDesc());
                productImageRequest.setImageUrl(productImage.getImageUrl());

                productImageDtoList.add(productImageRequest);
            }
            oneProductDto.setImageList(productImageDtoList);


            BaseResponseDto<OneProductDto> response = new BaseResponseDto<OneProductDto>(
                    HttpStatus.OK.value(),
                    true,
                    "아이디별 Product 조회 API 성공",
                    oneProductDto
            );
            return response;
        }
        else{
            BaseResponseDto<OneProductDto> response = new BaseResponseDto<OneProductDto>(
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    "아이디별 Product 조회 API 실패"
            );
            return response;
        }
    }

    public BaseResponseDto<AllProductResponse> getProductByName(String name){
        List<Product> productList;
        productList = productRepository.findByTitleContaining(name);
        if(productList.isEmpty()){
            return new BaseResponseDto<AllProductResponse>(
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    "이름별 Product 조회 API 실패: 검색 내용이 없습니다."
            );
        }
        else{
            List<ProductDto> productDtoList = new ArrayList<>();

            for (Product product : productList) {
                ProductDto productDto = new ProductDto();
                productDto.setProductId(product.getId());
                productDto.setTitle(product.getTitle());
                productDto.setContent(product.getContent());
                productDto.setPrice(product.getPrice());

                // 대표 이미지 설정 (이미지 URL을 가져오는 로직이 필요)
                List<ProductImage> imageUrl = productImageRepository.findByProduct(product);
                if(imageUrl.size() > 0)
                    productDto.setImageUrl(imageUrl.get(0).getImageUrl());

                productDtoList.add(productDto);
            }

            // Response 생성
            AllProductResponse allProductResponse = new AllProductResponse(productDtoList);
            BaseResponseDto<AllProductResponse> response = new BaseResponseDto<AllProductResponse>(
                    HttpStatus.OK.value(),
                    true,
                    "카테고리별 Product 조회 API",
                    allProductResponse
            );
            return response;
        }
    }
}
