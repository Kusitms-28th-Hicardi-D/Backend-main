package com.example.hicardi.domain.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    private String engName;

    @Column(nullable = false)
    private String content;

    private int price;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductOption> productOptions = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = new ArrayList<>();

    private String detailImage;

    private String category;

    public static Product createProduct(String title, String engName, String content, int price, String detailImage, String category) {
        return Product.builder()
                .title(title)
                .engName(engName)
                .content(content)
                .price(price)
                .detailImage(detailImage)
                .category(category)
                .build();
    }

    public void addProductOption(ProductOption productOption) {
        this.productOptions.add(productOption);
    }

    public void addProductImage(ProductImage image) {
        this.productImages.add(image);
    }

    public void setProductOptions(List<ProductOption> productOptions) {
        this.productOptions = productOptions;
    }
}
