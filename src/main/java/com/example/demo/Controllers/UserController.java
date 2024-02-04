package com.example.demo.Controllers;

import com.example.demo.DTO.RequestUser;
import com.example.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody RequestUser requestUser){
        userService.addUser(requestUser);
        return new ResponseEntity("user added", HttpStatus.CREATED);
    }
}
