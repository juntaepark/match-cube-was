package com.carnival.matchcube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SignInValueDTO {
    public int acntId;
    public String name;
    public String nickName;
    public String statusCode;
}
