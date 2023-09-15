package com.example.hicardi.domain.solution.repository;

import com.example.hicardi.domain.solution.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
