package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.LogInResponseDTO;
import com.carnival.matchcube.dto.SignUpDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SignUpMapper {
    public String findByUserEmail(String emailId) throws Exception ;
    public int insertAccount(SignUpDTO signUpDTO) throws Exception ;
}
