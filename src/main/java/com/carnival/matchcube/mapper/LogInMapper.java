package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.LogInDTO;
import com.carnival.matchcube.dto.LogInResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LogInMapper {

    public LogInResponseDTO logIn(LogInDTO logInDTO) throws Exception ;
}
