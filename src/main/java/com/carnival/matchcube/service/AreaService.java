package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.dto.AreaCodeValidDTO;
import com.carnival.matchcube.dto.AreaDTO;
import com.carnival.matchcube.dto.AreaValueDTO;
import com.carnival.matchcube.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.carnival.matchcube.Response.ResponseMessage.*;
import static com.carnival.matchcube.Response.StatusCode.*;

@Service
@Transactional
public class AreaService {

    Object statusCode = 406;

    @Autowired
    private AreaMapper areaMapper;

    public ResponseEntity getArea() throws Exception { //위치필터 : 시/도 조회
        List<AreaValueDTO> areaValueDTO = areaMapper.getArea();

        return new ResponseEntity(DefaultRes.res(OK, SUCCESS, areaValueDTO), HttpStatus.OK);
    }

    public ResponseEntity getUnderArea(AreaDTO areaDTO) throws Exception { //위치필터 : 시/도 code로 소속 시/군/구 조회
        List<AreaValueDTO> areaValueDTO = areaMapper.getUnderArea(areaDTO);
        boolean isValidCode = areaMapper.getValidArea(areaDTO);

        if(!isValidCode) //유효한 시/도 code가 아닐 경우
            return new ResponseEntity(DefaultRes.res(NOT_VALID_AREA_CODE, NOT_VALID_CITY_CODE), HttpStatus.OK);

        else
            return new ResponseEntity(DefaultRes.res(NOT_VALID_AREA_CODE, NOT_VALID_CITY_CODE, areaValueDTO), HttpStatus.OK);
    }
}
