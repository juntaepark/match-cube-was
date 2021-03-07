package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.Response.StatusCode;
import com.carnival.matchcube.dto.SignUpDTO;
import com.carnival.matchcube.mapper.SignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.carnival.matchcube.Response.ResponseMessage.CREATED_USER;
import static com.carnival.matchcube.Response.ResponseMessage.SIGNUP_FAIL;
import static com.carnival.matchcube.Response.StatusCode.*;

@Service
public class SignUpService {
    @Autowired
    private SignUpMapper signUpMapper;

    public ResponseEntity signUp(SignUpDTO signUpDTO) throws Exception {
        String email = verifyDuplicatedUser(signUpDTO.getEmailId());
        if( email != null){
            return new ResponseEntity(DefaultRes.res(DUPLICATE_EMAIL, SIGNUP_FAIL), HttpStatus.OK);
        }

        if(1 == signUpMapper.insertAccount(signUpDTO)){
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, CREATED_USER), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(DefaultRes.res(SIGN_IN_FAIL, SIGNUP_FAIL), HttpStatus.OK);
        }
    }

    // 이메일 중복 확인
    public String verifyDuplicatedUser(String emailId)throws Exception {
        return signUpMapper.findByUserEmail(emailId);
    }
}
