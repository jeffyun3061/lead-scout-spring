package com.leadscout.backend.repository;

import com.leadscout.backend.domain.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Long> {

    // 특정 기업 ID로 연결된 프로필 전체 조회
    List<CompanyProfile> findByCompanyDataId(Long companyId);
}
