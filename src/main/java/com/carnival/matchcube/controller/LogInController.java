package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.SignInDTO;
import com.carnival.matchcube.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logIn")
public class LogInController {

    @Autowired
    private LogInService logInService;

    // SignIn API
    @PostMapping
    public ResponseEntity logIn(SignInDTO signInDTO) throws Exception {
        return logInService.logIn(signInDTO);
    }
}