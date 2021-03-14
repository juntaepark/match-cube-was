package com.carnival.matchcube.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class MyUpdateDTO {
    public Long accountId;
    public String nickName;
}
