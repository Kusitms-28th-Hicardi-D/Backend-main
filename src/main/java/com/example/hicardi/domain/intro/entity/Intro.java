package com.example.hicardi.domain.intro.entity;

import com.example.hicardi.domain.BaseEntity;
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
public class Intro extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "intro_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "intro")
    @Builder.Default
    private List<IntroInfo> infoList = new ArrayList<>();

    @OneToMany(mappedBy = "intro")
    @Builder.Default
    private List<IntroVideo> videoList = new ArrayList<>();

    public static Intro createIntro(String name){
        return Intro.builder()
                .name(name)
                .build();
    }

    public void addIntroInfo(IntroInfo introInfo){
        this.infoList.add(introInfo);
    }

    public void addIntroVideo(IntroVideo introVideo){
        this.videoList.add(introVideo);
    }
}
