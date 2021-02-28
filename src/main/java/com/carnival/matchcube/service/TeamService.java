package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.dto.TeamValueDTO;
import com.carnival.matchcube.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.carnival.matchcube.Response.ResponseMessage.*;
import static com.carnival.matchcube.Response.StatusCode.*;

@Service
@Transactional
public class TeamService {
    Object StatusCode = 407;

    @Autowired
    private TeamMapper teamMapper;

    public ResponseEntity makeTeam() throws Exception {
        TeamValueDTO teamValueDTO = teamMapper.makeTeam();

        return new ResponseEntity(DefaultRes.res(OK, LOGIN_FAIL, teamValueDTO), HttpStatus.OK);

    }
}
