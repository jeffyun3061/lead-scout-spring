package com.leadscout.backend.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PdfAnalysisDto {

    private String address;
    private String productsServices;
    private String companyDescription;
    private String businessModel;
    private String strengths;
    private String competitors;
    private String targetCustomers;

    private String email;
    private String homepage;
    private String industry;
    private String keyExecutive;
    private String phoneNumber;

    private BigDecimal sales;
    private BigDecimal totalFunding;

    private Long companyId;
    private Long profileId;
}
