package com.leadscout.backend.controller;

import com.leadscout.backend.domain.CompanyData;
import com.leadscout.backend.dto.CompanyDataDto;
import com.leadscout.backend.service.CompanyDataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
@Tag(name = "Company Data", description = "기업 기본 정보 CRUD API")
public class CompanyDataController {

    private final CompanyDataService service;

    @PostMapping
    @Operation(summary = "기업 등록", description = "기업 기본 정보를 등록합니다.")
    public CompanyData create(@RequestBody CompanyDataDto dto) {
        return service.create(dto);
    }

    @GetMapping
    @Operation(summary = "전체 기업 목록 조회", description = "모든 기업의 정보를 조회합니다.")
    public List<CompanyData> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "기업 단건 조회", description = "기업 ID를 기준으로 상세 정보를 조회합니다.")
    public CompanyData findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "기업 정보 수정", description = "기존 기업의 정보를 수정합니다.")
    public CompanyData update(@PathVariable Long id, @RequestBody CompanyDataDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "기업 삭제", description = "기업 정보를 삭제합니다.")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search")
    @Operation(summary = "회사명 검색", description = "회사명 일부를 기준으로 검색합니다. 예: ?keyword=카카오")
    public List<CompanyData> searchByName(@RequestParam String keyword) {
        return service.searchByCompanyName(keyword);
    }

    @GetMapping("/industry")
    @Operation(summary = "산업군별 조회", description = "industry 값을 기준으로 해당 기업들을 필터링합니다. 예: ?industry=AI")
    public List<CompanyData> searchByIndustry(@RequestParam String industry) {
        return service.searchByIndustry(industry);
    }
}
