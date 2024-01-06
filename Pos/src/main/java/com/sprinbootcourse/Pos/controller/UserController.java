package com.sprinbootcourse.Pos.controller;

import com.sprinbootcourse.Pos.dto.UserDTO;
import com.sprinbootcourse.Pos.dto.request.LoginRQ;
import com.sprinbootcourse.Pos.services.UserService;
import com.sprinbootcourse.Pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<StandardResponse> createUser(@RequestBody UserDTO userDTO){
        String response = this.userService.createUser(userDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"create user",response), HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/login",
            params = {"username","password"}
    )
    public ResponseEntity<StandardResponse> getLoggedUser(
            @RequestParam(value = "username") String userName,
            @RequestParam(value = "password") String password
    ){

        Boolean user = this.userService.getLoggedUser(userName,password);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Logging request",user), HttpStatus.OK
        );
    }
}

