package com.example.hicardi.domain.solution.service;

import com.example.hicardi.domain.solution.dto.res.ReviewResponseDto;
import com.example.hicardi.domain.solution.dto.res.SolutionResponseDto;
import com.example.hicardi.domain.solution.dto.res.SolutionTestResponseDto;
import com.example.hicardi.domain.solution.entity.Review;
import com.example.hicardi.domain.solution.entity.Solution;
import com.example.hicardi.domain.solution.entity.SolutionTest;
import com.example.hicardi.domain.solution.repository.ReviewRepository;
import com.example.hicardi.domain.solution.repository.SolutionRepository;
import com.example.hicardi.domain.solution.repository.SolutionTestRepository;
import com.example.hicardi.global.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class SolutionService {

    private final SolutionRepository solutionRepository;
    private final SolutionTestRepository solutionTestRepository;
    private final ReviewRepository reviewRepository;
    private final S3Service s3Service;

    public long createSolution(String solutionName) {
        Solution solution = Solution.createSolution(solutionName);

        return solutionRepository.save(solution).getId();
    }

    public SolutionResponseDto findSolution(String solutionName) {
        Solution solution = getSolution(solutionName);

        List<ReviewResponseDto> reviews = solution.getReviews().stream()
                .map(review -> ReviewResponseDto.of(review.getWriter(), review.getContent()))
                .collect(Collectors.toList());

        List<SolutionTestResponseDto> tests = solution.getTests().stream()
                .map(test -> SolutionTestResponseDto.of(test.getTitle(), test.getCategory(), test.getImage(), test.getFileKey()))
                .collect(Collectors.toList());

        return SolutionResponseDto.of(solution.getName(), reviews, tests);
    }

    public Solution getSolution(String solutionName) {
        return solutionRepository.findSolutionByNameIs(solutionName);
    }

    public long createReview(String solutionName, String writer, String content) {
        Solution solution = getSolution(solutionName);
        Review review = Review.createReviewWithSolution(solution, writer, content);

        return reviewRepository.save(review).getId();
    }

    public long createTest(
            String title, String category, String image, String fileName, String solutionName
    ) {

        Solution solution = getSolution(solutionName);
        SolutionTest solutionTest = SolutionTest.createSolutionTestWithSolution(
                title, category, image, fileName, solution
        );

        return solutionTestRepository.save(solutionTest).getId();
    }
}
