package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.SignUpDTO;
import com.carnival.matchcube.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController{
    @Autowired
    private SignUpService SignUpService;

    // SignUp Api
    @PostMapping
    public ResponseEntity signUp(@RequestBody SignUpDTO signUpDTO) throws Exception {
        return SignUpService.signUp(signUpDTO);
    }

}