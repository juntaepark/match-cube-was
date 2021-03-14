package com.carnival.matchcube.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TeamDTO {
    public String URL;
    public int category;
    public String name;
    public String area;
    public String introduction;
    public int uniform;
    public int leader;
    public int vehicle;
    public int fee;
    public String period;
}