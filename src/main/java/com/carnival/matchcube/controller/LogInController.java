package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.LogInDTO;
import com.carnival.matchcube.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LogInController {

    @Autowired
    private LogInService logInService;

    // Login Api
    @PostMapping
    public ResponseEntity logIn(LogInDTO logInDTO) throws Exception {
        return logInService.logIn(logInDTO);
    }

    // Kakao Login Api
    // 1.Authorization Server에서 로그인 정보를 확인하고 인증해 Code를 받음
    // 2.Kakao Resource Server에 접근해 로그인 한 사용자의 정보를 갖고옴
    // Code+ClientId+ClientSecret을 통해 Kakao Authorization Server에서 Access Token을 발급
    @GetMapping("/oauth2/code/kakao")
    public ResponseEntity kakaoLogin(String code) throws Exception {
        return logInService.kakaoLogin(code);
    }

}
