package com.carnival.matchcube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TeamDTO {
    public String name;
    public int location;
    public String URL;
    public int category;
    public int leader;
}
