package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.LogInDTO;
import com.carnival.matchcube.dto.LogInValueDTO;
import com.carnival.matchcube.dto.MyAccountDTO;
import com.carnival.matchcube.dto.MyAccountValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MyAccountMapper {
    MyAccountValueDTO myAccount(MyAccountDTO myAccountDTO) throws Exception ;
}
