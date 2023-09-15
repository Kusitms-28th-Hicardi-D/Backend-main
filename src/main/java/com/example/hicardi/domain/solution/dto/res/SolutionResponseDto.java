package com.example.hicardi.domain.solution.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
public class SolutionResponseDto {

    private String name;
    private List<ReviewResponseDto> reviews;
    private List<SolutionTestResponseDto> tests;
}
