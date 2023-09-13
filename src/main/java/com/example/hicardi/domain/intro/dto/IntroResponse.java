package com.example.hicardi.domain.intro.dto;

import com.example.hicardi.domain.intro.entity.IntroInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class IntroResponse {
    private Long introId;
    private String name;
    private List<IntroInfo> introInfoList;

    public IntroResponse(Long introId) {
        this.introId = introId;
    }

    public IntroResponse(Long introId, String name) {
        this.introId = introId;
        this.name = name;
    }

    public IntroResponse(Long introId, String name, List<IntroInfo> introInfoList) {
        this.introId = introId;
        this.name = name;
        this.introInfoList = introInfoList;
    }

}