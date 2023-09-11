package com.example.hicardi.domain.intro.entity;

import com.example.hicardi.domain.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class IntroInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "intro_info_id")
    private Long id;

    @Column(nullable = false)
    private String linkDesc;

    @Column(nullable = false)
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intro_id")
    private Intro intro;

    public static IntroInfo createIntroInfo(String linkDesc, String link, Intro intro) {
        return IntroInfo.builder()
                .linkDesc(linkDesc)
                .link(link)
                .intro(intro)
                .build();
    }
}
