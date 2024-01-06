package com.sprinbootcourse.Pos.services;

import com.sprinbootcourse.Pos.dto.UserDTO;
import com.sprinbootcourse.Pos.dto.request.LoginRQ;

public interface UserService {
    String createUser(UserDTO userDTO);

    boolean getLoggedUser(String userName, String password);
}
