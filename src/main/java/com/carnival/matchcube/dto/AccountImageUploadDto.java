package com.carnival.matchcube.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AccountImageUploadDto {
    public MultipartFile file;
    public int accountId;
}
