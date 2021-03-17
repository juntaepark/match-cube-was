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
        ValidDTO sameURL = teamMapper.isSameImage(teamDTO.URL);

        if(sameURL.isMatched == 1) { //같은 사진으로 다른 팀을 등록하려는 경우
            return new ResponseEntity(NoDataRes.noDataRes(DUPLICATED_TEAM_IMAGE, DUPLICATED_TEAM_IMAGE_URL), HttpStatus.OK);
        }
        else {
            teamMapper.insertImage(teamDTO.URL);
            teamMapper.makeTeam(teamDTO);
            ValidDTO isMatched = teamMapper.isMatchedTeamId(teamDTO.URL);

            if(isMatched.isMatched == 0) { //team_image 테이블의 team_id와 team_ex 테이블의 team_id가 일치하지 않는 경우
                //URL을 WHERE 절 조건으로 해서 team_ex 테이블의 team_id 값을 team_image 테이블 team_id에 넣고 팀을 바르게 생성한다.
                teamMapper.adjustTeamId(teamDTO.URL);
                return new ResponseEntity(NoDataRes.noDataRes(OK, MAKE_SUCCESS), HttpStatus.OK);
            }
            else
                return new ResponseEntity(NoDataRes.noDataRes(OK, MAKE_SUCCESS), HttpStatus.OK);
        }
    }

    public ResponseEntity isDuplicateName(TeamDTO teamDTO) throws Exception { //팀명 중복체크
        ValidDTO isValidCode = teamMapper.isDuplicateTeamName(teamDTO.category, teamDTO.name);

        if(isValidCode.isMatched == 1) { //이미 같은 팀명이 있는 경우
            return new ResponseEntity(NoDataRes.noDataRes(DUPLICATE_TEAM_NAME, DUPLICATED_TEAM_NAME_STRING), HttpStatus.OK);
        } else {
            if(teamDTO.name.length() > 20) { //팀명의 길이가 너무 긴 경우
                return new ResponseEntity(NoDataRes.noDataRes(TOO_LONG_TEAM_NAME, TOO_LONG_TEAM_NAME_STRING), HttpStatus.OK);
            } else
                return new ResponseEntity(NoDataRes.noDataRes(POSSIBLE_TEAM_NAME, POSSIBLE_TEAM_NAME_STRING), HttpStatus.OK);
        }
    }

    public ResponseEntity getMoreMyTeamInfo(int teamId) throws Exception {
        TeamDTO teamValueDTO = teamMapper.getMoreMyTeamInfo(teamId);

        return new ResponseEntity(DefaultRes.res(OK, SUCCESS, teamValueDTO), HttpStatus.OK);
    }

    public ResponseEntity editTeamInfo() throws Exception {
        TeamShowValueDTO teamValueDTO = teamMapper.editTeamInfo();

        return new ResponseEntity(DefaultRes.res(OK, SUCCESS, teamValueDTO), HttpStatus.OK);
    }

    public ResponseEntity showTeam(TeamShowDTO teamShowDTO) throws Exception {
        List<TeamShowValueDTO> teamShowValueDTO = teamMapper.showTeam(teamShowDTO);
        if (teamShowValueDTO.isEmpty()) {
            return new ResponseEntity(DefaultRes.res(NO_CONTENT, NO_EXIST_TEAMS, teamShowValueDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity(DefaultRes.res(OK, TEAM_SHOW_SUCCESS, teamShowValueDTO), HttpStatus.OK);
        }

    }
}
