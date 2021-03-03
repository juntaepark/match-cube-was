package com.carnival.matchcube.mapper;


import com.carnival.matchcube.dto.TeamDTO;

import com.carnival.matchcube.dto.TeamShowDTO;

import com.carnival.matchcube.dto.TeamValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeamMapper {
    Boolean isValidTeamName(String name) throws Exception;
    TeamValueDTO makeTeam(TeamDTO teamDTO) throws Exception;
    TeamValueDTO getTeamList() throws Exception;
    public List<TeamValueDTO> showTeam(TeamShowDTO teamShowDTO) throws Exception;
}
