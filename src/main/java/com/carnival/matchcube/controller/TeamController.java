package com.carnival.matchcube.controller;

import com.carnival.matchcube.dto.TeamDTO;
import com.carnival.matchcube.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carnival.matchcube.dto.TeamShowDTO;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("")
    public ResponseEntity makeTeam(@RequestBody TeamDTO teamDTO) throws Exception { //팀 생성
        return teamService.makeTeam(teamDTO);
    }

    @GetMapping("/name")
    public ResponseEntity isDuplicateName(@RequestBody TeamDTO teamDTO) throws Exception { //팀명 중복체크
        return teamService.isDuplicateName(teamDTO);
    }

    @GetMapping("/my")
    public ResponseEntity getMoreMyTeamInfo(@PathVariable int teamId) throws Exception { //나의 팀 상세화면 정보 조회
        return teamService.getMoreMyTeamInfo(teamId);
    }

    @PatchMapping("")
    public ResponseEntity editTeamInfo() throws Exception { //팀 정보 편집
        return teamService.editTeamInfo();
    }
    @GetMapping
    public ResponseEntity showTeam(TeamShowDTO teamShowDTO) throws Exception { //필터 적용 팀 조회
        return teamService.showTeam(teamShowDTO);
    }
}
