package com.carnival.matchcube.mapper;

<<<<<<< HEAD
import com.carnival.matchcube.dto.TeamDTO;
=======
import com.carnival.matchcube.dto.TeamShowDTO;
>>>>>>> jin
import com.carnival.matchcube.dto.TeamValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeamMapper {
<<<<<<< HEAD
    Boolean isValidTeamName(String name) throws Exception;
    TeamValueDTO makeTeam(TeamDTO teamDTO) throws Exception;
    TeamValueDTO getTeamList() throws Exception;
=======
    TeamValueDTO makeTeam() throws Exception;
    public List<TeamValueDTO> showTeam(TeamShowDTO teamShowDTO) throws Exception;
>>>>>>> jin
}
