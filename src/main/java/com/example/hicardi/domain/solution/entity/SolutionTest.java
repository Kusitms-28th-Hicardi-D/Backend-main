package com.example.hicardi.domain.solution.entity;

import com.example.hicardi.domain.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SolutionTest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String fileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solution_id")
    private Solution solution;

    public static SolutionTest createSolutionTestWithSolution(String name, String category, String fileName, Solution solution){
        SolutionTest solutionTest = SolutionTest.builder()
                .name(name)
                .category(category)
                .fileName(fileName)
                .solution(solution)
                .build();
        solution.addTest(solutionTest);
        return solutionTest;
    }

}
