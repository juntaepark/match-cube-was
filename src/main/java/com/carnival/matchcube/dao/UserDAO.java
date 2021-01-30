package com.carnival.matchcube.dao;

import com.carnival.matchcube.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDAO {
    List<UserDTO> selectUsers(UserDTO param) throws Exception;
}
