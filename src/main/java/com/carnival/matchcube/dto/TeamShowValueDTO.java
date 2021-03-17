package com.carnival.matchcube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
@Setter
public class TeamShowValueDTO {
    public String teamName;
    public String teamImageUrl;
    public char wantPlayer;
    public char wantMercenary;
    public char wantMatch;
}
