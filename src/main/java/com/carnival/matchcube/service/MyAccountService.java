package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.Response.ResponseMessage;
import com.carnival.matchcube.Response.StatusCode;
import com.carnival.matchcube.dto.MyAccountDTO;
import com.carnival.matchcube.dto.MyAccountValueDTO;
import com.carnival.matchcube.mapper.MyAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.carnival.matchcube.Response.ResponseMessage.DB_ERROR;
import static com.carnival.matchcube.Response.ResponseMessage.LOGIN_FAIL;
import static com.carnival.matchcube.Response.StatusCode.NO_CONTENT;

@Service
@Transactional
public class MyAccountService {
    @Autowired
    private MyAccountMapper myAccountMapper;

    public ResponseEntity myAccount(MyAccountDTO myAccountDTO) throws Exception {
        MyAccountValueDTO myAccountValueDTO = myAccountMapper.myAccount(myAccountDTO);
        if(myAccountValueDTO == null){
            return new ResponseEntity(DefaultRes.res(NO_CONTENT, DB_ERROR), HttpStatus.OK);
        }
        else{
            System.out.println(myAccountValueDTO);
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS, myAccountValueDTO), HttpStatus.OK);
        }
    }
}
