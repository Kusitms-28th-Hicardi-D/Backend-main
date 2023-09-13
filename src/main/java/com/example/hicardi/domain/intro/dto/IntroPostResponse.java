package com.example.hicardi.domain.intro.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntroPostResponse {
    private Long introId;

    public IntroPostResponse(Long introId) {
        this.introId = introId;
    }
}
