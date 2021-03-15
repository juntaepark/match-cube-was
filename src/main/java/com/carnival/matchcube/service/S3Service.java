package com.carnival.matchcube.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.carnival.matchcube.component.S3Component;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@RequiredArgsConstructor
@Component
public class S3Service {

    private final AmazonS3Client amazonS3Client;
    private final S3Component s3Component;

//    aws-cloud-starter-aws 라이브러리에서 제공하는 AmazonS3Client를 사용해서 다음과 같이 파일을 업로드 (uploadFile)
//    아래 메소드는 업로드한 파일의 URI를 가져오는 메소드
//    S3Component는 AWS S3를 위한 설정 파일이 담긴 클래스
    public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {
        try{
            amazonS3Client.putObject(new PutObjectRequest(s3Component.getBucket(), fileName, inputStream, objectMetadata).withCannedAcl(CannedAccessControlList.Private));
        } catch (AmazonServiceException e){
            // The call was transmitted successfully, but Amazon S3 couldn't process
            // it, so it returned an error response.
            e.printStackTrace();
        } catch (SdkClientException e) {
            // Amazon S3 couldn't be contacted for a response, or the client
            // couldn't parse the response from Amazon S3.
            e.printStackTrace();
        }
    }

    public String getFileUrl(String fileName) {
        return String.valueOf(amazonS3Client.getUrl(s3Component.getBucket(), fileName));
    }


}
