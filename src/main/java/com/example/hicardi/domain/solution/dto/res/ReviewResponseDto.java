package com.example.hicardi.domain.solution.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
public class ReviewResponseDto {

    private String writer;
    private String content;
}
