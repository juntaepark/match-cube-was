package com.carnival.matchcube.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
public class TeamFileUploadDto {
    public MultipartFile file;
    public int teamId;
    public int accountId;
    public String url;
}

