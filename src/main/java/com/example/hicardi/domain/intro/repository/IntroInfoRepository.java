package com.example.hicardi.domain.intro.repository;

import com.example.hicardi.domain.intro.entity.Intro;
import com.example.hicardi.domain.intro.entity.IntroInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IntroInfoRepository extends JpaRepository<IntroInfo, Long> {
    //List<IntroInfo> findByIntro(Intro intro);
    List<IntroInfo> findByIntro(Intro intro);
}
