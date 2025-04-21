package com.leadscout.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyProfileDto {

    private String fileName;
    private String url;

    private Long companyId;   // 어떤 기업(CompanyData)에 속한 프로필인지 연결하기 위한 ID
}
