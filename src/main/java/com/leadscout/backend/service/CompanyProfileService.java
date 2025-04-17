package com.leadscout.backend.service;

import com.leadscout.backend.domain.CompanyProfile;
import com.leadscout.backend.dto.CompanyProfileDto;
import com.leadscout.backend.repository.CompanyProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyProfileService {

    private final CompanyProfileRepository repository;

    public CompanyProfile create(CompanyProfileDto dto) {
        CompanyProfile entity = CompanyProfile.builder()
                .companyName(dto.getCompanyName())
                .industry(dto.getIndustry())
                .homepage(dto.getHomepage())
                .keyExecutive(dto.getKeyExecutive())
                .address(dto.getAddress())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .description(dto.getDescription())
                .pdfUrl(dto.getPdfUrl())
                .build();

        return repository.save(entity);
    }

    public List<CompanyProfile> findAll() {
        return repository.findAll();
    }

    public CompanyProfile findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public CompanyProfile update(Long id, CompanyProfileDto dto) {
        CompanyProfile entity = repository.findById(id).orElseThrow();

        entity.setCompanyName(dto.getCompanyName());
        entity.setIndustry(dto.getIndustry());
        entity.setHomepage(dto.getHomepage());
        entity.setKeyExecutive(dto.getKeyExecutive());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setDescription(dto.getDescription());
        entity.setPdfUrl(dto.getPdfUrl());

        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
