package com.carnival.matchcube.service;

import com.carnival.matchcube.Response.DefaultRes;
import com.carnival.matchcube.Response.NoDataRes;
import com.carnival.matchcube.Response.ResponseMessage;
import com.carnival.matchcube.Response.StatusCode;
import com.carnival.matchcube.dto.MyAccountDTO;
import com.carnival.matchcube.dto.MyAccountValueDTO;
import com.carnival.matchcube.dto.MyTeamValueDTO;
import com.carnival.matchcube.dto.MyUpdateDTO;
import com.carnival.matchcube.mapper.MyAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.carnival.matchcube.Response.ResponseMessage.*;
import static com.carnival.matchcube.Response.StatusCode.*;

@Service
public class MyAccountService {
    @Autowired
    private MyAccountMapper myAccountMapper;

    @Transactional
    public ResponseEntity myAccount(MyAccountDTO myAccountDTO) throws Exception {
        List <MyAccountValueDTO> myAccountValueDTO= myAccountMapper.myAccount(myAccountDTO);
        if (myAccountValueDTO.isEmpty()) {
            return new ResponseEntity(NoDataRes.noDataRes(NOT_VALID_ACCOUNT_ID, NOT_EXIST_USER), HttpStatus.OK);
        } else {
            System.out.println(myAccountValueDTO);
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS, myAccountValueDTO), HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity myTeam(MyAccountDTO myAccountDTO) throws Exception {
        List<MyTeamValueDTO> myTeamValueDTO = myAccountMapper.myTeam(myAccountDTO);
        List <MyAccountValueDTO> myAccountValueDTO = myAccountMapper.myAccount(myAccountDTO);
        if (myAccountValueDTO.isEmpty()) {
            return new ResponseEntity(NoDataRes.noDataRes(NOT_VALID_ACCOUNT_ID, NOT_EXIST_USER), HttpStatus.OK);
        }
        else if (myTeamValueDTO.isEmpty()){
            return new ResponseEntity(NoDataRes.noDataRes(NO_HAVE_TEAMS, NO_TEAM_USER), HttpStatus.OK);
        }
        else {
            System.out.println(myTeamValueDTO);
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.SUCCESS, myTeamValueDTO), HttpStatus.OK);
        }
    }

    @Transactional
    public ResponseEntity myUpdate(MyUpdateDTO myUpdateDTO) throws Exception{
        if (0 == myAccountMapper.myUpdate(myUpdateDTO)) {
            return new ResponseEntity(NoDataRes.noDataRes(NOT_VALID_ACCOUNT_ID, NOT_EXIST_USER), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(DefaultRes.res(StatusCode.OK, UPDATE_USER), HttpStatus.OK);
        }

    }

}
