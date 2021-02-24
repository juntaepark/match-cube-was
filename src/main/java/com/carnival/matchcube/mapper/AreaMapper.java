package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.AreaCodeValidDTO;
import com.carnival.matchcube.dto.AreaDTO;
import com.carnival.matchcube.dto.AreaValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AreaMapper {
    List<AreaValueDTO > getArea() throws Exception; //시도 받아오기
    List<AreaValueDTO> getUnderArea(AreaDTO areaDTO) throws Exception; //areaDTO로 시/도 code 받아서 해당 시/도의 시/군/구 받기
    boolean getValidArea(AreaDTO areaDTO) throws Exception; //시/도code 유효성 검사
}
