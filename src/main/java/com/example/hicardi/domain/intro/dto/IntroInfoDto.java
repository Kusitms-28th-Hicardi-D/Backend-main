package com.example.hicardi.domain.intro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntroInfoDto {
    private String linkDesc;
    private String linkUrl;

    public IntroInfoDto(String linkDesc, String linkUrl) {
        this.linkDesc = linkDesc;
        this.linkUrl = linkUrl;
    }

}
