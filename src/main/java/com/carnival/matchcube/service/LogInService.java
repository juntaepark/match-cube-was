package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.Response.ResponseMessage;
import com.carnival.matchcube.Response.StatusCode;
import com.carnival.matchcube.dto.SignInDTO;
import com.carnival.matchcube.dto.SignInValueDTO;
import com.carnival.matchcube.mapper.LogInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.carnival.matchcube.Response.ResponseMessage.LOGIN_FAIL;
import static com.carnival.matchcube.Response.StatusCode.NO_CONTENT;

@Service
@Transactional
public class LogInService {

    @Autowired
    private LogInMapper logInMapper;

    public ResponseEntity logIn(SignInDTO signInDTO) throws Exception {
        SignInValueDTO signInValueDTO = logInMapper.logIn(signInDTO);

        if(signInValueDTO == null){
            return new ResponseEntity(DefaultRes.res(NO_CONTENT, LOGIN_FAIL), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, signInValueDTO), HttpStatus.OK);
        }
    }
}
