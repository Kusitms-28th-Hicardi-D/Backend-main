package com.example.hicardi.domain.member.entity;

import com.example.hicardi.domain.BaseEntity;
import com.example.hicardi.domain.solution.entity.Review;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contact;

    public static Member createMember(String username, String password, String email, String contact){
        return Member.builder()
                .username(username)
                .password(password)
                .email(email)
                .contact(contact)
                .build();
    }
}
