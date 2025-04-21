package com.leadscout.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "scout_agent_pdfanalysis")
public class PdfAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String address;

    @Lob
    private String productsServices;

    @Lob
    private String companyDescription;

    @Lob
    private String businessModel;

    @Lob
    private String strengths;

    @Lob
    private String competitors;

    @Lob
    private String targetCustomers;

    private String email;
    private String homepage;
    private String industry;
    private String keyExecutive;
    private String phoneNumber;

    @Column(precision = 15, scale = 2)
    private BigDecimal sales;

    @Column(name = "total_funding", precision = 15, scale = 2)
    private BigDecimal totalFunding;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyData companyData;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private CompanyProfile companyProfile;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
