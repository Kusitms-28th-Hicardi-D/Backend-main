package com.example.hicardi.domain.intro.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class IntroRequest {
    private String name;
    private List<IntroInfoRequest> introInfoList;
    private List<IntroVideoRequest> introVideoList;
}
