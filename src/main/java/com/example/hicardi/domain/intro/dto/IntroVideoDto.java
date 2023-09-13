package com.example.hicardi.domain.intro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntroVideoDto {
    private String videoDesc;
    private String videoUrl;

    public IntroVideoDto(String videoDesc, String videoUrl) {
        this.videoDesc = videoDesc;
        this.videoUrl = videoUrl;
    }
}
