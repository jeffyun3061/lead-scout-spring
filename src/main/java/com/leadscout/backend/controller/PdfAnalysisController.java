package com.leadscout.backend.controller;

import com.leadscout.backend.domain.PdfAnalysis;
import com.leadscout.backend.dto.PdfAnalysisDto;
import com.leadscout.backend.service.PdfAnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/analysis")
@Tag(name = "PDF 분석 결과", description = "회사소개서 PDF에 대한 AI 분석 결과 API")
public class PdfAnalysisController {

    private final PdfAnalysisService service;

    @PostMapping
    @Operation(summary = "PDF 분석 결과 저장", description = "분석된 내용을 저장합니다. 기업 ID, 프로필 ID와 함께 전송해야 합니다.")
    public PdfAnalysis create(@RequestBody PdfAnalysisDto dto) {
        return service.create(dto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "분석 결과 단건 조회", description = "ID로 분석 정보를 조회합니다.")
    public PdfAnalysis findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/company/{companyId}")
    @Operation(summary = "특정 기업의 전체 분석 결과", description = "기업 ID로 해당 기업의 모든 분석 결과를 조회합니다.")
    public List<PdfAnalysis> findByCompanyId(@PathVariable Long companyId) {
        return service.findByCompanyId(companyId);
    }

    @GetMapping("/profile/{profileId}")
    @Operation(summary = "특정 프로필의 분석 결과", description = "소개서 프로필 ID로 분석 결과를 조회합니다.")
    public PdfAnalysis findByProfileId(@PathVariable Long profileId) {
        return service.findByProfileId(profileId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "분석 결과 삭제", description = "ID로 분석 데이터를 삭제합니다.")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
