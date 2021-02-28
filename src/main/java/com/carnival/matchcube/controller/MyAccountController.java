package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.MyAccountDTO;
import com.carnival.matchcube.service.MyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myAccount")
public class MyAccountController {
    @Autowired
    private MyAccountService myAccountService;

    @GetMapping("/{accountId}")
    public ResponseEntity myAccount(@PathVariable("accountId") Long accountId) throws Exception {
        MyAccountDTO myAccountDTO = new MyAccountDTO(accountId);
        return myAccountService.myAccount(myAccountDTO);
    }
}
