package com.example.hicardi.domain.member.entity;


import com.example.hicardi.domain.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Subscribe extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscribe_id")
    private Long id;

    @Column(nullable = false)
    private String email;
}
