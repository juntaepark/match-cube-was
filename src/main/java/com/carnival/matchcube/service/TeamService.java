package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;


import com.carnival.matchcube.Response.isSuccess;
import com.carnival.matchcube.dto.CodeValidDTO;
import com.carnival.matchcube.dto.TeamDTO;

import com.carnival.matchcube.dto.TeamShowDTO;

import com.carnival.matchcube.dto.TeamValueDTO;
import com.carnival.matchcube.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.carnival.matchcube.Response.ResponseMessage.*;
import static com.carnival.matchcube.Response.StatusCode.*;

@Service
public class TeamService {
    Object StatusCode = 408;

    @Autowired
    private TeamMapper teamMapper;


    public ResponseEntity makeTeam(TeamDTO teamDTO) throws Exception {
        String name = teamDTO.name;
        CodeValidDTO isValidCode = teamMapper.isDuplicateTeamName(teamDTO.name);

        if (isValidCode.exist == 1) { //이미 같은 팀명이 있는 경우
            return new ResponseEntity(DefaultRes.res(isSuccess.FAIL, DUPLICATE_TEAM_NAME, DUPLICATED_TEAM_NAME), HttpStatus.OK);
        } else {
            teamMapper.makeTeam(teamDTO);
            return new ResponseEntity(DefaultRes.res(isSuccess.SUCCESS, OK, MAKE_SUCCESS), HttpStatus.OK);
        }

    }

    public ResponseEntity getTeamList() throws Exception {
        TeamValueDTO teamValueDTO = teamMapper.getTeamList();

        return new ResponseEntity(DefaultRes.res(isSuccess.SUCCESS, OK, SUCCESS, teamValueDTO), HttpStatus.OK);
    }

    public ResponseEntity showTeam(TeamShowDTO teamShowDTO) throws Exception {
        List<TeamValueDTO> teamValueDTO = teamMapper.showTeam(teamShowDTO);
        if (teamValueDTO.isEmpty()) {
            return new ResponseEntity(DefaultRes.res(isSuccess.FAIL, NO_CONTENT, NO_EXIST_TEAMS, teamValueDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity(DefaultRes.res(isSuccess.SUCCESS, OK, TEAM_SHOW_SUCCESS, teamValueDTO), HttpStatus.OK);
        }

    }
}
