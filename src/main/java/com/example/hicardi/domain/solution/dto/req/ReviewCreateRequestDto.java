package com.example.hicardi.domain.solution.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewCreateRequestDto {

    private String solutionName;
    private String writer;
    private String content;
}
