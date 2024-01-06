package com.sprinbootcourse.Pos.services.impl;

import com.sprinbootcourse.Pos.dto.UserDTO;
import com.sprinbootcourse.Pos.dto.request.LoginRQ;
import com.sprinbootcourse.Pos.model.User;
import com.sprinbootcourse.Pos.repo.UserRepo;
import com.sprinbootcourse.Pos.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String createUser(UserDTO userDTO) {
        User user = this.modelMapper.map(userDTO,User.class);
        this.userRepo.save(user);
        return user.getUserName() + " Created";
    }

    @Override
    public boolean getLoggedUser(String userName, String password) {

        boolean validator = this.userRepo.existsByUserNameAndPassword(userName,password);
        return validator;
    }
}
