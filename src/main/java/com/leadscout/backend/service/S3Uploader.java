package com.leadscout.backend.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class S3Uploader {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    @Autowired
    public S3Uploader(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public String uploadFile(File file, String fileName) {
        String bucketName = "lead-scout-files";

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("application/pdf");
        metadata.setContentLength(file.length());

        try (InputStream inputStream = new FileInputStream(file)) {
            amazonS3.putObject(
                    new PutObjectRequest(bucketName, fileName, inputStream, metadata)
            );
            return amazonS3.getUrl(bucketName, fileName).toString();
        } catch (IOException e) {
            throw new RuntimeException("S3 파일 업로드 실패", e);
        }
    }
}
