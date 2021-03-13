package com.carnival.matchcube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class MyAccountValueDTO {
    public BigInteger accountId;
    public String nickName;
    public String name;
    public String emailId;
    public BigInteger teamId;
    public String teamImageUrl;
    public String isTeamLeader;
}
