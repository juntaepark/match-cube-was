package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.AreaDTO;
import com.carnival.matchcube.dto.AreaValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AreaMapper {
    List<AreaValueDTO > getArea() throws Exception;
    AreaValueDTO getUnderArea(AreaDTO areaDTO) throws Exception;
}
