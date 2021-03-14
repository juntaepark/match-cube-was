package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.MyAccountDTO;
import com.carnival.matchcube.dto.MyAccountValueDTO;
import com.carnival.matchcube.dto.MyTeamValueDTO;
import com.carnival.matchcube.dto.MyUpdateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyAccountMapper {
    List<MyAccountValueDTO> myAccount(MyAccountDTO myAccountDTO) throws Exception ;
    List<MyTeamValueDTO> myTeam(MyAccountDTO myAccountDTO) throws Exception ;
    int myUpdate(MyUpdateDTO myUpdateDTO) throws Exception ;
}
