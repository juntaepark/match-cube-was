package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.MyAccountDTO;
import com.carnival.matchcube.service.MyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myAccount")
public class MyAccountController {
    @Autowired
    private MyAccountService myAccountService;

    @GetMapping
    public ResponseEntity myAccount(MyAccountDTO myAccountDTO) throws Exception {
        return myAccountService.myAccount(myAccountDTO);
    }
}
