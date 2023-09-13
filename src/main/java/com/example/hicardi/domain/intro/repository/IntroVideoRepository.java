package com.example.hicardi.domain.intro.repository;

import com.example.hicardi.domain.intro.entity.Intro;
import com.example.hicardi.domain.intro.entity.IntroVideo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntroVideoRepository extends JpaRepository<IntroVideo, Long> {
    List<IntroVideo> findByIntro(Intro intro);
}
