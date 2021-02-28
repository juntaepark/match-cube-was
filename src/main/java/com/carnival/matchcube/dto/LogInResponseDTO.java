package com.carnival.matchcube.dto;

import lombok.*;

@Data
public class LogInResponseDTO {
    public String emailId;
    public String password;
    public int accountId;
    public String name;
    public String nickName;
    public String status;
}


