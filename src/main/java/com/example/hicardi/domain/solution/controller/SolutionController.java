package com.example.hicardi.domain.solution.controller;

import com.example.hicardi.domain.solution.dto.req.ReviewCreateRequestDto;
import com.example.hicardi.domain.solution.dto.req.SolutionTestCreateRequestDto;
import com.example.hicardi.domain.solution.service.SolutionService;
import com.example.hicardi.global.S3Service;
import com.example.hicardi.global.response.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/solution")
@RequiredArgsConstructor
public class SolutionController {

    private final SolutionService solutionService;
    private final S3Service s3Service;

    @GetMapping("/{name}")
    public BaseResponseDto<?> findSolution(
            @PathVariable String name
    ) {
        return new BaseResponseDto<>(solutionService.findSolution(name));
    }

    @PostMapping("")
    public BaseResponseDto<?> createSolution(
            @RequestParam String solutionName
    ) {
        return new BaseResponseDto<>(solutionService.createSolution(solutionName));
    }

    @PostMapping("/review")
    public BaseResponseDto<?> reviewSolution(
            @RequestBody ReviewCreateRequestDto requestDto
            ) {
        return new BaseResponseDto<>(solutionService.createReview(
                requestDto.getSolutionName(),
                requestDto.getWriter(),
                requestDto.getContent()
        ));
    }

    @PostMapping("/test")
    public BaseResponseDto<?> createTest(
            @RequestBody SolutionTestCreateRequestDto requestDto
    ) {
        log.info("fileName: {}", requestDto.getFileKey());

        return new BaseResponseDto<>(solutionService.createTest(
                requestDto.getTitle(),
                requestDto.getCategory(),
                requestDto.getImage(),
                requestDto.getFileKey(),
                requestDto.getSolutionName()
        ));
    }

    @PostMapping("/test/image")
    public BaseResponseDto<?> uploadImage(
            @RequestPart MultipartFile file
    ) {
        return new BaseResponseDto<>(s3Service.uploadImage(file, "solution_image"));
    }

    @PostMapping("/test/file")
    public BaseResponseDto<?> uploadFile(
            @RequestPart MultipartFile file
    ) {
        return new BaseResponseDto<>(s3Service.uploadPdf(file, "solution_pdf"));
    }

    @GetMapping("/test/file")
    public ResponseEntity<byte[]> downloadFile(
            @RequestParam String key,
            @RequestParam String downloadFileName
    ) {
        return s3Service.downloadPdf(key, downloadFileName);
    }
}
