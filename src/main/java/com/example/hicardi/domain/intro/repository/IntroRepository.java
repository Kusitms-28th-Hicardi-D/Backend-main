package com.example.hicardi.domain.intro.repository;

import com.example.hicardi.domain.intro.entity.Intro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntroRepository extends JpaRepository<Intro, Long> {
}
