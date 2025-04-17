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
@RequestMapping("/api/company")
@RequiredArgsConstructor
@Tag(name = "Company Profile", description = "기업 프로필 CRUD API")
public class CompanyProfileController {

    private final CompanyProfileService service;

    @Operation(summary = "기업 등록", description = "기업 프로필을 등록합니다.")
    @PostMapping
    public CompanyProfile create(@RequestBody CompanyProfileDto dto) {
        return service.create(dto);
    }

    @Operation(summary = "전체 조회", description = "모든 기업 목록을 조회합니다.")
    @GetMapping
    public List<CompanyProfile> findAll() {
        return service.findAll();
    }

    @Operation(summary = "단일 조회", description = "특정 기업 정보를 조회합니다.")
    @GetMapping("/{id}")
    public CompanyProfile findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "기업 수정", description = "기업 정보를 수정합니다.")
    @PutMapping("/{id}")
    public CompanyProfile update(@PathVariable Long id, @RequestBody CompanyProfileDto dto) {
        return service.update(id, dto);
    }

    @Operation(summary = "기업 삭제", description = "기업 정보를 삭제합니다.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
