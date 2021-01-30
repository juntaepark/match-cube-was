package com.carnival.matchcube.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//  아래 코드에 지정된 대로 기본 경로 "/"로 접근시 Hello!라는 메세지를 반환
//  웹 브라우저에서 localhost:8080 으로 테스트
    @RequestMapping("/")
    public String index(){
        return "Hello!";
    }

}
