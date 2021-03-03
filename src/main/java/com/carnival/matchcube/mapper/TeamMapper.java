package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.CodeValidDTO;
import com.carnival.matchcube.dto.TeamDTO;
import com.carnival.matchcube.dto.TeamValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeamMapper {
    CodeValidDTO isDuplicateTeamName(String name) throws Exception;
    TeamValueDTO makeTeam(TeamDTO teamDTO) throws Exception;
    TeamValueDTO getTeamList() throws Exception;
}
