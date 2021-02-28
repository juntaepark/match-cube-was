package com.carnival.matchcube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TeamValueDTO {
    public String name;
    public String location;
    public String URL;
    public String category;
    public int leader;
}
