package com.example.hicardi.domain.solution.repository;

import com.example.hicardi.domain.solution.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {

    Solution findSolutionByNameIs(String solutionName);
}
