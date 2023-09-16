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
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_option_id")
    private Long id;

    @Column(nullable = false, name="option_name")
    private String name;

    @Column(nullable = false, name="option_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public static ProductOption createProductOption(String name, String content, Product product) {
        return ProductOption.builder()
                .name(name)
                .content(content)
                .product(product)
                .build();
    }
}
