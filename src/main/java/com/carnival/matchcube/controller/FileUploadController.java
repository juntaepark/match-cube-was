package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.AccountFileUploadDto;
import com.carnival.matchcube.dto.TeamFileUploadDto;
import com.carnival.matchcube.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    // 개인 파일 업로드
    @PostMapping("/account")
    public ResponseEntity accountImageUpload(AccountFileUploadDto accountFileUploadDto) {

        return fileUploadService.accountImageUpload(accountFileUploadDto);
    }
    // team 파일 업로드
    @PostMapping("/team")
    public ResponseEntity teamImageUpload(TeamFileUploadDto teamFileUploadDto) {

        return fileUploadService.teamImageUpload(teamFileUploadDto);
    }


    // 개인 사진 삭제

    // team 사진 삭제

}
