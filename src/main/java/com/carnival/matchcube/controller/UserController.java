package com.carnival.matchcube.controller;

import com.carnival.matchcube.dao.UserDAO;
import com.carnival.matchcube.dto.UserDTO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 사용자 요청을 처리하고 응답을 전송하는 컨트롤러를 정의
// 맵퍼()를 탐색할 패키지 지정
@RestController
@MapperScan(basePackages = "com.carnival.matchcube.dao")
public class UserController {
//    UserDAO bean을 자동으로 주입
    @Autowired
    private UserDAO userDAO;

//  Query String으로 country를 받도록 설정
    @RequestMapping("/users") // Handler level Mapping
    public List<UserDTO> users(@RequestParam(value = "country", defaultValue = "") String country) throws Exception{
//      전달받은 country를 가진 UserDTO형 객체를 생성합니다. 이 객체는 MyBatis에 파라미터로 전달
        final UserDTO param = new UserDTO(0, null, country);
//      생성한 객체를 파라미터로 전달하여 DB로부터 사용자 목록 조회
        final List<UserDTO> userList = userDAO.selectUsers(param);
        return userList;
    }
}
