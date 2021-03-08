package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.MyAccountDTO;
import com.carnival.matchcube.dto.MyAccountValueDTO;
import com.carnival.matchcube.dto.MyTeamValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyAccountMapper {
    public List<MyAccountValueDTO> myAccount(MyAccountDTO myAccountDTO) throws Exception ;
    public List<MyTeamValueDTO> myTeam(MyAccountDTO myAccountDTO) throws Exception ;
}
