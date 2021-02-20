package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.SignInDTO;
import com.carnival.matchcube.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signin")
public class SignInController {

    @Autowired
    private SignInService signInService;

    // SignIn API
    @PostMapping
    public ResponseEntity signIn(SignInDTO signInDTO) throws Exception {
        return signInService.signIn(signInDTO);
    }
}
