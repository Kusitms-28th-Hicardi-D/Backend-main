package com.example.hicardi.domain.intro.dto;

import com.example.hicardi.domain.intro.entity.IntroInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IntroInfoListDto {
    private Long introId;
    private String name;
    private List<IntroInfoDto> introInfoList;

    public IntroInfoListDto(Long introId, String name, List<IntroInfoDto> introInfoList) {
        this.introId = introId;
        this.name = name;
        this.introInfoList = introInfoList;
    }
}
