package com.leadscout.backend.service;

import com.leadscout.backend.domain.CompanyData;
import com.leadscout.backend.domain.CompanyProfile;
import com.leadscout.backend.domain.PdfAnalysis;
import com.leadscout.backend.dto.PdfAnalysisDto;
import com.leadscout.backend.repository.CompanyDataRepository;
import com.leadscout.backend.repository.CompanyProfileRepository;
import com.leadscout.backend.repository.PdfAnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PdfAnalysisService {

    private final PdfAnalysisRepository analysisRepo;
    private final CompanyDataRepository companyDataRepo;
    private final CompanyProfileRepository profileRepo;

    public PdfAnalysis create(PdfAnalysisDto dto) {
        CompanyData companyData = companyDataRepo.findById(dto.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("기업 정보가 존재하지 않습니다."));

        CompanyProfile profile = profileRepo.findById(dto.getProfileId())
                .orElseThrow(() -> new IllegalArgumentException("프로필 정보가 존재하지 않습니다."));

        PdfAnalysis analysis = PdfAnalysis.builder()
                .address(dto.getAddress())
                .productsServices(dto.getProductsServices())
                .companyDescription(dto.getCompanyDescription())
                .businessModel(dto.getBusinessModel())
                .strengths(dto.getStrengths())
                .competitors(dto.getCompetitors())
                .targetCustomers(dto.getTargetCustomers())
                .email(dto.getEmail())
                .homepage(dto.getHomepage())
                .industry(dto.getIndustry())
                .keyExecutive(dto.getKeyExecutive())
                .phoneNumber(dto.getPhoneNumber())
                .sales(dto.getSales())
                .totalFunding(dto.getTotalFunding())
                .companyData(companyData)
                .companyProfile(profile)
                .build();

        return analysisRepo.save(analysis);
    }

    public PdfAnalysis findById(Long id) {
        return analysisRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 분석 정보가 존재하지 않습니다."));
    }

    public List<PdfAnalysis> findByCompanyId(Long companyId) {
        return analysisRepo.findByCompanyDataId(companyId);
    }

    public PdfAnalysis findByProfileId(Long profileId) {
        return analysisRepo.findByCompanyProfileId(profileId);
    }

    public void delete(Long id) {
        analysisRepo.deleteById(id);
    }
}
