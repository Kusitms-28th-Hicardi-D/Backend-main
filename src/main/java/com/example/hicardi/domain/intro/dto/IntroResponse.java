package com.example.hicardi.domain.intro.dto;

import com.example.hicardi.domain.intro.entity.IntroInfo;
import com.example.hicardi.domain.intro.entity.IntroVideo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class IntroResponse {
    private Long introId;

    public IntroResponse(Long introId) {
        this.introId = introId;
    }

}