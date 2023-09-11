package com.example.hicardi.domain.intro.repository;

import com.example.hicardi.domain.intro.entity.IntroInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntroInfoRepository extends JpaRepository<IntroInfo, Long> {
}
