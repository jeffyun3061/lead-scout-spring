package com.leadscout.backend.repository;

import com.leadscout.backend.domain.CompanyData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyDataRepository extends JpaRepository<CompanyData, Long> {

    // 회사 이름으로 검색 (부분 일치)
    List<CompanyData> findByCompanyContaining(String keyword);

    // 산업 분야로 검색 (선택적으로 사용 가능)
    List<CompanyData> findByIndustry(String industry);
}
