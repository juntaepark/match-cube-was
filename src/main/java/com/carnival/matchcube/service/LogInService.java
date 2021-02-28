package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.Response.ResponseMessage;
import com.carnival.matchcube.Response.StatusCode;
import com.carnival.matchcube.dto.KakaoOauthDTO;
import com.carnival.matchcube.dto.LogInDTO;
import com.carnival.matchcube.dto.LogInResponseDTO;
import com.carnival.matchcube.mapper.LogInMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.carnival.matchcube.Response.ResponseMessage.EMAIL_NOTFOUND;
import static com.carnival.matchcube.Response.ResponseMessage.LOGIN_FAIL;
import static com.carnival.matchcube.Response.StatusCode.NO_CONTENT;
import static com.carnival.matchcube.Response.StatusCode.NO_EMAIL;

@Service
public class LogInService {

    @Autowired
    private LogInMapper logInMapper;

    @Transactional
    public ResponseEntity logIn(LogInDTO logInDTO) throws Exception {
        LogInResponseDTO logInResponseDTO = logInMapper.logIn(logInDTO);
        if(logInResponseDTO == null){
            return new ResponseEntity(DefaultRes.res(NO_EMAIL, EMAIL_NOTFOUND), HttpStatus.OK);
        }
        else if (! logInResponseDTO.password.equals(logInDTO.getPassword())){
            return new ResponseEntity(DefaultRes.res(NO_CONTENT, LOGIN_FAIL), HttpStatus.OK);
        }
        else{
            System.out.println(logInResponseDTO);
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, logInResponseDTO), HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity kakaoLogin(String code) throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "52449b413d05675eed244b6baaceee56");
        params.add("redirect_uri", "http://localhost:8080/login/oauth2/code/kakao");
        params.add("code", code);
        params.add("client_secret", "j2ijWgsNbVfHySxXq9suql4uY7pP47cl");

        //HttpHeader 오브젝트 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        //HttpHeader와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

        //POST방식으로 key-value 데이터를 요청(카카오쪽으로)
        RestTemplate rt = new RestTemplate(); //http 요청을 간단하게 해줄 수 있는 클래스

        //Http 요청/POST/response응답
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        //ObjectMapper:JSON객체의 key값에 맞는 변수에 저장을 시켜주는 클래스
        ObjectMapper objectMapper = new ObjectMapper();
        KakaoOauthDTO kakaoOauthToken =null;
        try {
            kakaoOauthToken = objectMapper.readValue(response.getBody(), KakaoOauthDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if(kakaoOauthToken == null){
            return new ResponseEntity(DefaultRes.res(NO_CONTENT, LOGIN_FAIL), HttpStatus.OK);
        }
        else{
            System.out.println(kakaoOauthToken);
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, kakaoOauthToken), HttpStatus.OK);
        }

        // Access Token으로 Kakao Resource Server에서 사용자의 정보 가져오기
//        HttpHeaders profileHeaders = new HttpHeaders();
//        profileHeaders.add("Authorization", "Bearer "+ kakaoOauthToken.getAccess_token());
//        profileHeaders.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

//        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);
//        ResponseEntity<String> profileResponse = rt.exchange(
//                "https://kapi.kakao.com/v2/user/me",
//                HttpMethod.POST,
//                kakaoProfileRequest,
//                String.class
//        );

//        ObjectMapper objectMapper2 = new ObjectMapper();
//        KakaoProfileDTO profile  =null;

//        try {
//            profile = objectMapper2.readValue(response.getBody(), KakaoProfileDTO.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }
}
