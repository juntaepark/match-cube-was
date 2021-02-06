package com.carnival.matchcube.service;

import com.carnival.matchcube.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service // "이 클래스틑 RESTful API를 위한 서비스 클래스이다"라고 스프링에게 알려줌
@Transactional // 트랜잭션을 시작하고, 정상 여부에 따라 Commit 또는 Rollback
public class UserService {

    @Autowired
    private UserMapper mapper;

    public List<HashMap<Object, Object>> selectData(){
        return mapper.selectData();
    }

    public List<HashMap<Object, Object>> pselectData(HashMap<Object, Object> vo){
        return mapper.pselectData(vo);
    }

    public int postInsert(HashMap<Object, Object> vo) throws Exception {
        return mapper.pinsert(vo);
    }

}
