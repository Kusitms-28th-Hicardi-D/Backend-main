package com.example.hicardi.domain.product.dto;

import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.domain.product.entity.ProductImage;
import com.example.hicardi.domain.product.entity.ProductOption;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OneProductDto {
    private Long productId;
    private String title;
    private String engName;
    private String content;
    private int price;
    private List<ProductOptionRequest> optionList;
    private List<ProductImageRequest> imageList;
    private String detailImg;

    public OneProductDto (Product entity) {
        this.productId = entity.getId();
        this.title = entity.getTitle();
        this.engName = entity.getEngName();
        this.content = entity.getContent();
        this.price = entity.getPrice();
        this.detailImg = entity.getDetailImage();
    }
}
