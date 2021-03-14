package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.Response.NoDataRes;
import com.carnival.matchcube.dto.*;

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

    @Transactional
    public ResponseEntity makeTeam(TeamDTO teamDTO) throws Exception {
        ValidDTO isValidCode = teamMapper.isDuplicateTeamName(teamDTO.name);
        ValidDTO sameURL = teamMapper.isSameImage(teamDTO.URL);

        if (isValidCode.isMatched == 1) { //이미 같은 팀명이 있는 경우
            return new ResponseEntity(NoDataRes.noDataRes(DUPLICATE_TEAM_NAME, DUPLICATED_TEAM_NAME), HttpStatus.OK);
        }

        else if (sameURL.isMatched == 1) { //같은 사진으로 다른 팀을 등록하려는 경우
            return new ResponseEntity(NoDataRes.noDataRes(DUPLICATED_TEAM_IMAGE, DUPLICATED_TEAM_IMAGE_URL), HttpStatus.OK);
        }

        else {
            teamMapper.insertImage(teamDTO.URL);
            teamMapper.makeTeam(teamDTO);
            ValidDTO isMatched = teamMapper.isMatchedTeamId(teamDTO.URL); //이게 Null이 나오는 문제가 있어!!!

            if(isMatched.isMatched == 0) { //team_image 테이블의 team_id와 team_ex 테이블의 team_id가 일치하지 않는 경우
                //URL을 WHERE 절 조건으로 해서 team_ex 테이블의 team_id 값을 team_image 테이블 team_id에 넣어준다.
                teamMapper.adjustTeamId(teamDTO.URL);
                return new ResponseEntity(NoDataRes.noDataRes(OK, MAKE_SUCCESS), HttpStatus.OK);
            }
            else
                return new ResponseEntity(NoDataRes.noDataRes(OK, MAKE_SUCCESS), HttpStatus.OK);
        }

    }

    public ResponseEntity editTeamInfo() throws Exception {
        TeamValueDTO teamValueDTO = teamMapper.editTeamInfo();

        return new ResponseEntity(DefaultRes.res(OK, SUCCESS, teamValueDTO), HttpStatus.OK);
    }

    public ResponseEntity showTeam(TeamShowDTO teamShowDTO) throws Exception {
        List<TeamValueDTO> teamValueDTO = teamMapper.showTeam(teamShowDTO);
        if (teamValueDTO.isEmpty()) {
            return new ResponseEntity(DefaultRes.res(NO_CONTENT, NO_EXIST_TEAMS, teamValueDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity(DefaultRes.res(OK, TEAM_SHOW_SUCCESS, teamValueDTO), HttpStatus.OK);
        }

    }
}
