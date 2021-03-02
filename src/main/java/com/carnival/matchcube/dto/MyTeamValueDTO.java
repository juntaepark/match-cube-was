package com.carnival.matchcube.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
public class MyTeamValueDTO {
    public Long relationId;
    public Integer teamId;
    public Integer accountId;
    public Integer linkNumber;
    public Boolean status;
    public Boolean isAccept;
    public Timestamp registerAt;
}
