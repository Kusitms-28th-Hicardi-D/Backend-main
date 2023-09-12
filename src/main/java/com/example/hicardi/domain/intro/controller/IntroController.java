package com.example.hicardi.domain.intro.controller;

import com.example.hicardi.domain.intro.dto.IntroRequest;
import com.example.hicardi.domain.intro.dto.IntroResponse;
import com.example.hicardi.domain.intro.entity.Intro;
import com.example.hicardi.domain.intro.entity.IntroInfo;
import com.example.hicardi.domain.intro.repository.IntroInfoRepository;
import com.example.hicardi.domain.intro.repository.IntroRepository;
import com.example.hicardi.domain.intro.service.IntroService;
import com.example.hicardi.global.response.BaseResponseDto;
import com.example.hicardi.global.response.SuccessMessage;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/intro")
public class IntroController {

    @Autowired
    private IntroService introService;

    // Intro 생성 및 IntroInfo 목록 생성 API
    @PostMapping("/create")
    @ApiOperation(value = "Intro 생성 및 IntroInfo 목록 생성 API", response= Intro.class)
    public ResponseEntity<BaseResponseDto<IntroResponse>> createIntro(@RequestBody IntroRequest introRequest) {
        BaseResponseDto<IntroResponse> response = introService.createIntro(introRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
