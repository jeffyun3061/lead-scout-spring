package com.leadscout.backend.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDataDto {

    private String company;
    private String industry;
    private BigDecimal sales;
    private BigDecimal totalFunding;

    private String address;
    private String email;
    private String homepage;
    private String keyExecutive;
    private String logoUrl;
    private String phoneNumber;
}
