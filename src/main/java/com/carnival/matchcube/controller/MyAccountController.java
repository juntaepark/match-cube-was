package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.MyAccountDTO;
import com.carnival.matchcube.dto.MyUpdateDTO;
import com.carnival.matchcube.service.MyAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{accountId}/teams")
    public ResponseEntity myTeam(@PathVariable("accountId") Long accountId) throws Exception {
        MyAccountDTO myAccountDTO = new MyAccountDTO(accountId);
        return myAccountService.myTeam(myAccountDTO);
    }
    @PatchMapping
    public ResponseEntity myUpdate(MyUpdateDTO myUpdateDTO) throws Exception {
        return myAccountService.myUpdate(myUpdateDTO);
    }
}
