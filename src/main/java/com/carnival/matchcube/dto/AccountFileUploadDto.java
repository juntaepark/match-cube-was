package com.carnival.matchcube.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AccountFileUploadDto {
    public MultipartFile file;
    public int accountId;
    public String url;
}

