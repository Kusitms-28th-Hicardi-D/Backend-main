package com.example.hicardi.domain.solution.entity;

import com.example.hicardi.domain.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Solution extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "solution")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "solution")
    @Builder.Default
    private List<SolutionTest> tests = new ArrayList<>();

    public static Solution createSolution(String name){
        return Solution.builder()
                .name(name)
                .build();
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void addTest(SolutionTest test){
        this.tests.add(test);
    }
}
