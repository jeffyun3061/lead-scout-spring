
### 💡 설계 목표

- 회사당 **다중 PDF 업로드** 지원
- 각 PDF는 **AI 분석 결과와 1:1로 연결**
- 테이블 분리 명확 (`company_id`, `profile_id` 외래키 반영)


## 🚀 주요 기능 요약

### 📌 1. CompanyData - 기업 기본 정보 관리


회사명, 업종, 이메일, 대표자, 주소 등 | 기업 고유 정보 관리 |
다중 PDF 파일 업로드 구조의 루트 엔티티 |

| 다중 PDF 업로드 구조 | ✅ CompanyProfile 분리로 완벽 대응 |
| 각 PDF마다 분석 결과 1:1 연결 | ✅ PdfAnalysis → profile_id, company_id 보유 |
| DB 하나로 서버 여러 개 띄우기 대응 | ✅ 외래키 구조, 연관관계 완전 분리 |
| Swagger 기반 API 문서화 | ✅ 전 API 문서화 완료

📍 **Endpoint**: `/api/companies`

- `POST /api/companies` → 기업 등록
- `GET /api/companies` → 전체 조회
- `GET /api/companies/{id}` → 단건 조회
- `PUT /api/companies/{id}` → 수정
- `DELETE /api/companies/{id}` → 삭제
- `GET /api/companies/search?keyword=` → 회사명 검색
- `GET /api/companies/industry?industry=` → 산업별 검색


### 📌 2. CompanyProfile - PDF 파일 메타정보 관리


fileName, S3 URL, 업로드된 회사 ID | 실제 파일은 AWS S3에 업로드됨 |

📍 **Endpoint**: `/api/profiles`

- `POST /api/profiles` → 파일 메타 등록 (회사 ID 필요)
- `GET /api/profiles` → 전체 프로필 조회
- `GET /api/profiles/{id}` → 단건 조회
- `PUT /api/profiles/{id}` → 수정
- `DELETE /api/profiles/{id}` → 삭제
- `GET /api/profiles/company/{companyId}` → 특정 기업의 모든 PDF 조회


### 📌 3. FileUpload - AWS S3에  PDF 업로드


MultipartFile PDF를 S3에 업로드 후 URL 반환 | 메타정보 저장 전에 호출 |

📍 **Endpoint**: `/api/files/upload`

- `POST /api/files/upload`  
  → `MultipartFile file` 전송 시 S3 URL 반환

---

### 📌 4. PdfAnalysis - AI 분석 결과 저장


strengths, competitors, target_customers 등 분석 데이터 | 각 PDF에 대해 분석 결과 하나씩 연결됨 |

📍 **Endpoint**: `/api/analysis`

- `POST /api/analysis` → 분석 결과 등록 (`companyId`, `profileId` 포함)
- `GET /api/analysis/{id}` → 단건 조회
- `GET /api/analysis/company/{companyId}` → 기업 전체 분석 결과 조회
- `GET /api/analysis/profile/{profileId}` → 특정 PDF 분석 조회
- `DELETE /api/analysis/{id}` → 삭제

---

## 🧪 API 문서 (Swagger UI)

- URL: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## 🛠 기술 스택

- Java 17
- Spring Boot 3.x
- Spring Web, JPA
- AWS S3
- Swagger (springdoc-openapi)
- Gradle

---

## 📦 디렉토리 구조
📦 src/main/java/com/leadscout/backend

├── 📁 controller       # API 엔드포인트 (REST 컨트롤러)

├── 📁 domain           # Entity 클래스 (JPA 테이블 매핑)

├── 📁 dto              # 요청/응답 데이터 전송 객체

├── 📁 repository       # JPA Repository 인터페이스

├── 📁 service          # 비즈니스 로직 처리

├── 📁 config           # 설정 클래스 (예: S3, Swagger 등)

📦 src/main/resources

├── 📄 application.yml  # DB/S3 설정 파일

├── 📁 static           # 정적 리소스 (프론트엔드 사용 시)

├── 📁 templates        # 템플릿


## 🙋‍♂️ 작성자

**윤지용 (Backend Developer)**
- Spring 기반 백엔드 전반 구조 설계 및 구현
- AWS 연동, Swagger 문서화, ERD 기반 API 설계

