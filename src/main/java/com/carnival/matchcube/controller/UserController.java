package com.carnival.matchcube.controller;

import com.carnival.matchcube.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController // "이 클래스틑 RESTful API를 위한 컨트롤러 클래스이다"라고 스프링에게 알려줌
@RequestMapping("/api") // 구체적으로 어떤 경로인지 지정
public class UserController {

    @Autowired
    private UserService userService; // MyService bean(객체)을 자동으로 주입

    // 파라미터 없는 Get메서드 조회
    @GetMapping("/mc9001S")
    public List<HashMap<Object, Object>> mc9001S(){
        return userService.selectData();
    }

    // 파라미터가 필요한 Get메서드 조회 ( 쿼리스트링 )
    @GetMapping("/mc9002S")
    public List<HashMap<Object, Object>> mc9002S(@RequestParam(value = "acntId", defaultValue = "0") int acntId,
                                                 @RequestParam(value = "emailId") String emailId){
        HashMap map = new HashMap<Object, Object>();
        map.put("acntId", acntId);
        map.put("emailId", emailId);
        return userService.pselectData(map);
    }

    // Post메서드
    @PostMapping("/mc9003S")
    public int mc9003S(@RequestBody HashMap<Object, Object> vo) throws Exception { // @RequestBody - HTTP Response Body 부분을 JSON의 형태로 리턴 할 것임을 알려줌
        return userService.postInsert(vo);
    }

}
