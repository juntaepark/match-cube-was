package com.carnival.matchcube.mapper;

import com.carnival.matchcube.dto.AccountFileUploadDto;
import com.carnival.matchcube.dto.TeamFileUploadDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FileUploadMapper {

    public int accountFileUpload(AccountFileUploadDto accountFileUploadDto) ;
    public int teamFileUpload(TeamFileUploadDto teamFileUploadDto) ;
    public int leaderValidation(TeamFileUploadDto teamFileUploadDto) ;
}
