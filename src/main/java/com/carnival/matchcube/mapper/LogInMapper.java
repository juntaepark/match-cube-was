package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.LogInDTO;
import com.carnival.matchcube.dto.LogInValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LogInMapper {

    LogInValueDTO logIn(LogInDTO logInDTO) throws Exception ;

}
