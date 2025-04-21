package com.leadscout.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "scout_agent_companydata")
public class CompanyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String industry;

    @Column(precision = 15, scale = 2)
    private BigDecimal sales;

    @Column(name = "total_funding", precision = 15, scale = 2)
    private BigDecimal totalFunding;

    @Lob
    private String address;

    private String email;
    private String homepage;
    private String keyExecutive;
    private String logoUrl;
    private String phoneNumber;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "companyData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompanyProfile> profiles = new ArrayList<>();

    @OneToMany(mappedBy = "companyData", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PdfAnalysis> pdfAnalyses = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
