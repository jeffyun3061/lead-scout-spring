package com.leadscout.backend.dto;

import lombok.Data;

@Data
public class CompanyProfileDto {
    private String companyName;
    private String industry;
    private String homepage;
    private String keyExecutive;
    private String address;
    private String email;
    private String phoneNumber;
    private String description;
    private String pdfUrl;
}
