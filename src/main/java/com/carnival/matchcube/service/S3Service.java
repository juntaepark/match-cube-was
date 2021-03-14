package com.carnival.matchcube.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.carnival.matchcube.component.S3Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class S3Service {

    private AmazonS3Client amazonS3Client;

    private S3Component s3Component;


//    aws-cloud-starter-aws 라이브러리에서 제공하는 AmazonS3Client를 사용해서 다음과 같이 파일을 업로드 (uploadFile)
//    아래 메소드는 업로드한 파일의 URI를 가져오는 메소드
//    S3Component는 AWS S3를 위한 설정 파일이 담긴 클래스
    public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {
        System.out.println(" park jun tae ");
        System.out.println(inputStream + " " + objectMetadata + " " + fileName);
        System.out.println("jt - " + s3Component.getBucket());
        amazonS3Client.putObject(new PutObjectRequest(s3Component.getBucket(), fileName, inputStream, objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));
    }

    public String getFileUrl(String fileName) {
        return String.valueOf(amazonS3Client.getUrl(s3Component.getBucket(), fileName));
    }


}
