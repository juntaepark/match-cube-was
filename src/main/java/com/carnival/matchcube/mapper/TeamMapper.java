package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.TeamValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeamMapper {
    TeamValueDTO makeTeam() throws Exception;
}
