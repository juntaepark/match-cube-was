package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.AccountImageUploadDto;
import com.carnival.matchcube.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

//  @RequestPart - multipart/form-data 요청
    @PostMapping("/account")
    public ResponseEntity accountImageUpload(@ModelAttribute AccountImageUploadDto accountImageUploadDto) {
        return fileUploadService.accountImageUpload(accountImageUploadDto);
    }

}
