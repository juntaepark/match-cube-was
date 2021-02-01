package com.carnival.matchcube.controller;

import com.carnival.matchcube.model.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
// Member 컨트롤러 작성 및 테스트
// TestController와 달리 RequestMapping 어노테이션이 클래스 자체에 지정
// 테스트 api를 작성해서 객체를 잘 반환하는지 테스트
// 웹 브라우저에서 localhost:8080/member/test 으로 테스트
//http://localhost:8080/member/test2
@RequestMapping("/member")
@RestController
public class MemberController {

    @GetMapping("/test")
    public Member memberTest(){
        return new Member(0L, "parks", 29, "서울", new Date());
    }

    @GetMapping("/test2")
    public ArrayList<Member> memberTest2(){
        return new ArrayList(Arrays.asList(
                new Member(1L, "charlie", 29, "대전", new Date()),
                new Member(2L, "jin"    , 25, "종로", new Date()),
                new Member(3L, "lio"    , 26, "세종", new Date()),
                new Member(4L, "heather", 27, "서울", new Date()),
                new Member(5L, "kavin"  , 25, "강남", new Date())
        ));
    }
}