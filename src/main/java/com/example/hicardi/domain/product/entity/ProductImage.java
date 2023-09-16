package com.example.hicardi.domain.product.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Setter
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private Long id;

    @Column(nullable = false)
    private String imageDesc;

    @Column(nullable = false, unique = true)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public static ProductImage createProductImage(String imageDesc, String imageUrl, Product product) {
        return ProductImage.builder()
                .imageDesc(imageDesc)
                .imageUrl(imageUrl)
                .product(product)
                .build();
    }
}
