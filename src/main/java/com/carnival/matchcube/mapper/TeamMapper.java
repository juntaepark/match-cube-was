package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.TeamShowDTO;
import com.carnival.matchcube.dto.TeamValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeamMapper {
    TeamValueDTO makeTeam() throws Exception;
    public List<TeamValueDTO> showTeam(TeamShowDTO teamShowDTO) throws Exception;
}
