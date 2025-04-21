package com.leadscout.backend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "scout_agent_companyprofile")
public class CompanyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;  // PDF 파일 이름
    private String url;       // 업로드된 S3 URL

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 다대일: CompanyData 하나에 여러 Profile 가능
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyData companyData;

    // 일대일: 분석 결과는 하나의 Profile에 연결됨
    @OneToOne(mappedBy = "companyProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private PdfAnalysis pdfAnalysis;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
