package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.Response.ResponseMessage;
import com.carnival.matchcube.Response.StatusCode;
import com.carnival.matchcube.dto.CategoryValueDTO;
import com.carnival.matchcube.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.carnival.matchcube.Response.ResponseMessage.LOGIN_FAIL;
import static com.carnival.matchcube.Response.StatusCode.NO_CONTENT;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public ResponseEntity category() throws Exception {
        List<CategoryValueDTO> categoryValueDTO = categoryMapper.category();
        if(categoryValueDTO == null){
            return new ResponseEntity(DefaultRes.res(NO_CONTENT, LOGIN_FAIL), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, categoryValueDTO), HttpStatus.OK);
        }
    }
}
