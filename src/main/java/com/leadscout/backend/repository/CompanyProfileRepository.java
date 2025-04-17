package com.leadscout.backend.repository;

import com.leadscout.backend.domain.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Long> {
}
