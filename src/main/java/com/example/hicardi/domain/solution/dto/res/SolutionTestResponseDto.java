package com.example.hicardi.domain.solution.dto.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
public class SolutionTestResponseDto {

    private String title;
    private String category;
    private String image;
    private String fileKey;
}
