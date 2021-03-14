package com.carnival.matchcube.service;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.Response.StatusCode;
import com.carnival.matchcube.dto.AccountImageUploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static com.carnival.matchcube.Response.ResponseMessage.CREATED_USER;

@Service
public class FileUploadService {

    @Autowired
    private S3Service s3Service;

//    서비스 로직에서는 클라이언트로 부터 받은 MultiPartFile의 원래의 이름을 유니크하게 변경
//    이때 확장자는 계속 유효해함으로 유니크 키 + 확장자로 이름을 변 (ex-UUID.png)
//    S3에 저장할 때 같은 파일 이름이 있으면 에러가 발생
//    MultipartFile에서의 InputStream을 가져와서 실제 AWS S3로 파일을 전송하는 로직은 S3Service로 위임

    public ResponseEntity accountImageUpload(AccountImageUploadDto accountImageUploadDto) {
        String fileName = createFileName(accountImageUploadDto.getFile().getOriginalFilename());

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(accountImageUploadDto.getFile().getContentType());

        try (InputStream inputStream = accountImageUploadDto.getFile().getInputStream()) {
            s3Service.uploadFile(inputStream, objectMetadata, fileName);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("파일 변환 중 에러가 발생하였습니다 (%s)", accountImageUploadDto.getFile().getOriginalFilename()));
        }

        System.out.println(s3Service.getFileUrl(fileName));

        return new ResponseEntity(DefaultRes.res(StatusCode.OK, CREATED_USER), HttpStatus.OK);
    }

    private String createFileName(String originalFileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(originalFileName));
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("잘못된 형식의 파일 (%s) 입니다", fileName));
        }
    }

}
