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
public class IntroVideo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "intro_video_id")
    private Long id;

    @Column(nullable = false)
    private String videoUrl;

    @Column(nullable = false)
    private String videoDesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "intro_id")
    private Intro intro;

    public static IntroVideo createIntroVideo(String videoUrl, String videoDesc, Intro intro) {
        return IntroVideo.builder()
                .videoUrl(videoUrl)
                .videoDesc(videoDesc)
                .intro(intro)
                .build();
    }
}
