package com.example.hicardi.domain.intro.dto;

public class IntroResponse {
    private Long introId;

    public IntroResponse(Long introId) {
        this.introId = introId;
    }

    public Long getIntroId() {
        return introId;
    }

    public void setIntroId(Long introId) {
        this.introId = introId;
    }
}