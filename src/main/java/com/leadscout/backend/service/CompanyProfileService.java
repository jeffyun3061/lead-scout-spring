package com.leadscout.backend.service;

import com.leadscout.backend.domain.CompanyData;
import com.leadscout.backend.domain.CompanyProfile;
import com.leadscout.backend.dto.CompanyProfileDto;
import com.leadscout.backend.repository.CompanyDataRepository;
import com.leadscout.backend.repository.CompanyProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyProfileService {

    private final CompanyProfileRepository profileRepo;
    private final CompanyDataRepository dataRepo;

    public CompanyProfile create(CompanyProfileDto dto) {
        CompanyData companyData = dataRepo.findById(dto.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("해당 기업이 존재하지 않습니다: " + dto.getCompanyId()));

        CompanyProfile profile = CompanyProfile.builder()
                .fileName(dto.getFileName())
                .url(dto.getUrl())
                .companyData(companyData)
                .build();

        return profileRepo.save(profile);
    }

    public List<CompanyProfile> findAll() {
        return profileRepo.findAll();
    }

    public CompanyProfile findById(Long id) {
        return profileRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로필이 존재하지 않습니다: " + id));
    }

    public List<CompanyProfile> findByCompanyId(Long companyId) {
        return profileRepo.findByCompanyDataId(companyId);
    }

    public CompanyProfile update(Long id, CompanyProfileDto dto) {
        CompanyProfile profile = findById(id);

        profile.setFileName(dto.getFileName());
        profile.setUrl(dto.getUrl());

        // 회사 변경은 잘 안 하겠지만 혹시 모를 케이스 대비
        if (!profile.getCompanyData().getId().equals(dto.getCompanyId())) {
            CompanyData newCompany = dataRepo.findById(dto.getCompanyId())
                    .orElseThrow(() -> new IllegalArgumentException("기업 없음: " + dto.getCompanyId()));
            profile.setCompanyData(newCompany);
        }

        return profileRepo.save(profile);
    }

    public void delete(Long id) {
        profileRepo.deleteById(id);
    }
}
