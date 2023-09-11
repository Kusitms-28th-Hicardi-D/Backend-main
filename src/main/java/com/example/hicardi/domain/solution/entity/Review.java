package com.example.hicardi.domain.solution.entity;

import com.example.hicardi.domain.BaseEntity;
import com.example.hicardi.domain.member.entity.Member;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solution_id")
    private Solution solution;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String content;

    public static Review createReviewWithSolution(Member member, Solution solution, String writer, String content){
        Review review = Review.builder()
                .member(member)
                .solution(solution)
                .writer(writer)
                .content(content)
                .build();
        solution.addReview(review);
        return review;
    }
}
