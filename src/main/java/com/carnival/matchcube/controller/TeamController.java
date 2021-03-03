package com.carnival.matchcube.controller;

<<<<<<< HEAD
import com.carnival.matchcube.dto.TeamDTO;
import com.carnival.matchcube.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import com.carnival.matchcube.dto.TeamShowDTO;
import com.carnival.matchcube.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
>>>>>>> jin

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("")
    public ResponseEntity makeTeam(@RequestBody TeamDTO teamDTO) throws Exception {
        return teamService.makeTeam(teamDTO);
    }

    @PostMapping("-list")
    public ResponseEntity getTeamList() throws Exception {
        return teamService.getTeamList();
    }
    @GetMapping
    public ResponseEntity showTeam(TeamShowDTO teamShowDTO) throws Exception {
        return teamService.showTeam(teamShowDTO);
    }
}
