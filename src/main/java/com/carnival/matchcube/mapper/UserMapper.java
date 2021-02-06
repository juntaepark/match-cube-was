package com.carnival.matchcube.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<HashMap<Object, Object>> selectData();
    List<HashMap<Object, Object>> pselectData(HashMap<Object, Object> vo);
    int pinsert(HashMap<Object, Object> vo ) throws Exception ;
}
