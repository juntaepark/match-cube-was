package com.carnival.matchcube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class MyAccountValueDTO {
    public Long accountId;
    public String nickName;
    public String name;
    public String emailId;
    public Date birthday;
    public String sex;
    public String phoneNumber;
    public String intro;
    public String profileImageUrl;
}
