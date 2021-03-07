package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeamMapper {
    CodeValidDTO isDuplicateTeamName(String name) throws Exception;
    TeamValueDTO insertImage(String URL) throws Exception;
    TeamValueDTO makeTeam(TeamDTO teamDTO) throws Exception;
    ValidDTO isMatchedTeamId(String URL) throws Exception;
    TeamValueDTO adjustTeamId(String URL) throws Exception;
    TeamValueDTO getTeamList() throws Exception;
    public List<TeamValueDTO> showTeam(TeamShowDTO teamShowDTO) throws Exception;
}
