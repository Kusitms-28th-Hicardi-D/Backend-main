package com.example.hicardi.domain.product.entity;

import com.example.hicardi.domain.product.dto.DemoProductRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DemoProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "demo_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String clinic;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String solution;

    private String content;

    public static DemoProduct createDemoProduct(DemoProductRequest demoProductRequest){
        return DemoProduct.builder()
                .name(demoProductRequest.getName())
                .company(demoProductRequest.getCompany())
                .clinic(demoProductRequest.getClinic())
                .email(demoProductRequest.getEmail())
                .contact(demoProductRequest.getContact())
                .solution(demoProductRequest.getSolution())
                .content(demoProductRequest.getContent())
                .build();
    }
}
