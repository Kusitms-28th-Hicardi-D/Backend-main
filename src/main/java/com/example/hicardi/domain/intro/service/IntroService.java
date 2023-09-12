package com.example.hicardi.domain.intro.service;

import com.example.hicardi.domain.intro.dto.IntroInfoRequest;
import com.example.hicardi.domain.intro.dto.IntroRequest;
import com.example.hicardi.domain.intro.dto.IntroResponse;
import com.example.hicardi.domain.intro.entity.Intro;
import com.example.hicardi.domain.intro.entity.IntroInfo;
import com.example.hicardi.domain.intro.repository.IntroInfoRepository;
import com.example.hicardi.domain.intro.repository.IntroRepository;
import com.example.hicardi.domain.intro.repository.IntroVideoRepository;
import com.example.hicardi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IntroService {

    private final IntroRepository introRepository;
    private final IntroInfoRepository introInfoRepository;
    private final IntroVideoRepository introVideoRepository;

    @Transactional
    public BaseResponseDto<IntroResponse> createIntro(IntroRequest introRequest) {
        // Intro 생성
        Intro intro = Intro.createIntro(introRequest.getName());
        introRepository.save(intro);
        Long introId = intro.getId();

        // IntroInfo 목록 생성
        List<IntroInfo> introInfoList = new ArrayList<>();
        for (IntroInfoRequest infoRequest : introRequest.getIntroInfoList()) {
            introInfoList.add(IntroInfo.createIntroInfo(infoRequest.getLinkDesc(), infoRequest.getLinkUrl(), intro));
        }
        introInfoRepository.saveAll(introInfoList);

        // Response 생성
        IntroResponse introResponse = new IntroResponse(introId);
        BaseResponseDto<IntroResponse> response = new BaseResponseDto<IntroResponse>(
                HttpStatus.CREATED.value(),
                true,
                "Intro 생성 및 IntroInfo 목록 생성 API",
                introResponse
        );

        return response;
    }

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
