package com.leadscout.backend.service;

import com.leadscout.backend.domain.CompanyData;
import com.leadscout.backend.dto.CompanyDataDto;
import com.leadscout.backend.repository.CompanyDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyDataService {

    private final CompanyDataRepository repository;

    public CompanyData create(CompanyDataDto dto) {
        CompanyData entity = CompanyData.builder()
                .company(dto.getCompany())
                .industry(dto.getIndustry())
                .sales(dto.getSales())
                .totalFunding(dto.getTotalFunding())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .homepage(dto.getHomepage())
                .keyExecutive(dto.getKeyExecutive())
                .logoUrl(dto.getLogoUrl())
                .phoneNumber(dto.getPhoneNumber())
                .build();
        return repository.save(entity);
    }

    public List<CompanyData> findAll() {
        return repository.findAll();
    }

    public CompanyData findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 기업 정보를 찾을 수 없습니다. ID: " + id));
    }

    public List<CompanyData> searchByCompanyName(String keyword) {
        return repository.findByCompanyContaining(keyword);
    }

    public List<CompanyData> searchByIndustry(String industry) {
        return repository.findByIndustry(industry);
    }

    public CompanyData update(Long id, CompanyDataDto dto) {
        CompanyData company = findById(id);

        company.setCompany(dto.getCompany());
        company.setIndustry(dto.getIndustry());
        company.setSales(dto.getSales());
        company.setTotalFunding(dto.getTotalFunding());
        company.setAddress(dto.getAddress());
        company.setEmail(dto.getEmail());
        company.setHomepage(dto.getHomepage());
        company.setKeyExecutive(dto.getKeyExecutive());
        company.setLogoUrl(dto.getLogoUrl());
        company.setPhoneNumber(dto.getPhoneNumber());

        return repository.save(company);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
