package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.CategoryValueDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryMapper {
    public List<CategoryValueDTO> category() throws Exception ;
}
