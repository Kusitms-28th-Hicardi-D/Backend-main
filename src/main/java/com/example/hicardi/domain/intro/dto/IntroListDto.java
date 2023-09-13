package com.example.hicardi.domain.intro.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IntroListDto {
    private Long introId;
    private String name;
    private List<IntroInfoDto> introInfoList;
    private List<IntroVideoDto> introVideoList;

    public IntroListDto(Long introId, String name, List<IntroInfoDto> introInfoList, List<IntroVideoDto> introVideoList) {
        this.introId = introId;
        this.name = name;
        this.introInfoList = introInfoList;
        this.introVideoList = introVideoList;
    }
}
