package com.example.hicardi.domain.intro.service;

import com.example.hicardi.domain.intro.entity.Intro;
import com.example.hicardi.domain.intro.entity.IntroInfo;
import com.example.hicardi.domain.intro.repository.IntroInfoRepository;
import com.example.hicardi.domain.intro.repository.IntroRepository;
import com.example.hicardi.domain.intro.repository.IntroVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntroService {

    private final IntroRepository introRepository;
    private final IntroInfoRepository introInfoRepository;
    private final IntroVideoRepository introVideoRepository;

    public void createIntro(String name) {
        Intro intro = Intro.builder()
                .name(name)
                .build();

        introRepository.save(intro);
    }

    public void createIntroInfo(String linkDesc, String link, Intro intro) {
        IntroInfo introInfo = IntroInfo.createIntroInfo(linkDesc, link, intro);
        introInfoRepository.save(introInfo);
    }
}
