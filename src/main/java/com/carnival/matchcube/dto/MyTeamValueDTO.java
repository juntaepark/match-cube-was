package com.carnival.matchcube.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
public class MyTeamValueDTO {
    public Long teamId;
    public String teamName;
    public String teamImageUrl;
    public Integer memberCount;
    public Integer averageAge;
    public Integer athleteCount;
}
