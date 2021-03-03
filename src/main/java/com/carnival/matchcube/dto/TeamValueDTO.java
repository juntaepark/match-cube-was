package com.carnival.matchcube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class TeamValueDTO {
    public Integer teamId;
    public String status;
    public String teamName;
    public String teamLocation;
    public String team_image_url;
    public Integer categoryId;
    public Integer teamLeaderId;
    public String wantPlayer;
    public String wantHiring;
    public String wantMatch;
    public Timestamp createAt;
}
