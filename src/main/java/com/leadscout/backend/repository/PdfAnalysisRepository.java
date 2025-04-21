package com.leadscout.backend.repository;

import com.leadscout.backend.domain.PdfAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PdfAnalysisRepository extends JpaRepository<PdfAnalysis, Long> {

    // 특정 회사에 대한 모든 분석 조회
    List<PdfAnalysis> findByCompanyDataId(Long companyId);

    // 특정 프로필에 대한 분석 조회 (일대일 관계라 단건 예상)
    PdfAnalysis findByCompanyProfileId(Long profileId);
}
