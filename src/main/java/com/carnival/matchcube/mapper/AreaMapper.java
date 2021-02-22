package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.AreaDTO;
import com.carnival.matchcube.dto.AreaValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AreaMapper {
    AreaValueDTO getArea() throws Exception;
    AreaValueDTO getUnderArea(AreaDTO areaDTO) throws Exception;
}
