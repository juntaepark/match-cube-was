package com.carnival.matchcube.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

@Data
@AllArgsConstructor
public class Member {
//  Member 객체 모델 정의
//  model 패키지를 만들고 안에 Member 클래스를 생성
    private long id;
    private String name;
    private int age;
    private String address;
    private Date CreatedAt;
}
