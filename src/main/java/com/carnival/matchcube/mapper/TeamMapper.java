package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeamMapper {
    ValidDTO isDuplicateTeamName(int category, String name) throws Exception;
    ValidDTO isSameImage(String URL) throws Exception;
    TeamShowValueDTO insertImage(String URL) throws Exception;
    TeamShowValueDTO makeTeam(TeamDTO teamDTO) throws Exception;
    ValidDTO isMatchedTeamId(String URL) throws Exception;
    TeamShowValueDTO adjustTeamId(String URL) throws Exception;
    TeamDTO getMoreMyTeamInfo(int teamId) throws Exception;
    TeamShowValueDTO editTeamInfo() throws Exception;
    List<TeamShowValueDTO> showTeam(TeamShowDTO teamShowDTO) throws Exception;
}
