package com.example.hicardi.domain.solution.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SolutionTestCreateRequestDto {

    private String title;
    private String category;
    private String image;
    private String fileKey;
    private String solutionName;
}
