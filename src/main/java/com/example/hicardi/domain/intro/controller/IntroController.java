package com.example.hicardi.domain.intro.controller;

import com.example.hicardi.domain.intro.dto.IntroInfoListDto;
import com.example.hicardi.domain.intro.dto.IntroPostResponse;
import com.example.hicardi.domain.intro.dto.IntroRequest;
import com.example.hicardi.domain.intro.dto.IntroResponse;
import com.example.hicardi.domain.intro.entity.Intro;
import com.example.hicardi.domain.intro.service.IntroService;
import com.example.hicardi.global.response.BaseResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/intro")
public class IntroController {

    @Autowired
    private IntroService introService;

    // Intro 생성 및 IntroInfo 목록 생성 API
    @PostMapping("")
    @ApiOperation(value = "Intro 생성 API", response= Intro.class)
    public ResponseEntity<BaseResponseDto<IntroPostResponse>> createIntro(@RequestBody IntroRequest introRequest) {
        BaseResponseDto<IntroPostResponse> response = introService.createIntro(introRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // IntroInfo 조회 API
    @GetMapping("/{name}")
    @ApiOperation(value = "Intro 조회 API", response = BaseResponseDto.class)
    public ResponseEntity<BaseResponseDto<IntroInfoListDto>> getIntroByName(@PathVariable String name) {
        BaseResponseDto<IntroInfoListDto> response = introService.getIntroByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
