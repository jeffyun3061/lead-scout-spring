package com.leadscout.backend.controller;

import com.leadscout.backend.domain.CompanyProfile;
import com.leadscout.backend.dto.CompanyProfileDto;
import com.leadscout.backend.service.CompanyProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/profiles")
@Tag(name = "Company Profile", description = "기업 소개서 (PDF 파일 메타정보) API")
public class CompanyProfileController {

    private final CompanyProfileService service;

    @PostMapping
    @Operation(summary = "기업 프로필 등록", description = "파일 이름과 URL, 기업 ID로 프로필을 등록합니다.")
    public CompanyProfile create(@RequestBody CompanyProfileDto dto) {
        return service.create(dto);
    }

    @GetMapping
    @Operation(summary = "전체 프로필 조회", description = "모든 기업 소개서 목록을 조회합니다.")
    public List<CompanyProfile> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "프로필 단건 조회", description = "ID로 기업 소개서 단일 조회")
    public CompanyProfile findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/company/{companyId}")
    @Operation(summary = "특정 기업의 프로필 목록", description = "기업 ID로 해당 기업의 모든 소개서를 조회합니다.")
    public List<CompanyProfile> findByCompanyId(@PathVariable Long companyId) {
        return service.findByCompanyId(companyId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "프로필 수정", description = "PDF 파일명 및 URL 수정 (기업 변경도 가능)")
    public CompanyProfile update(@PathVariable Long id, @RequestBody CompanyProfileDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "프로필 삭제", description = "ID로 기업 소개서 삭제")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
