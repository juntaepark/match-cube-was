package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.SignInDTO;
import com.carnival.matchcube.dto.SignInValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LogInMapper {

    SignInValueDTO logIn(SignInDTO signInDTO) throws Exception ;

}
