package com.example.book.controller;

import com.example.book.model.MyUser;
import com.example.book.repository.MyUserRepository;
import com.example.book.response.BasicSuccessResp;
import com.example.book.response.ErrorResponse;
import com.example.book.service.UserService;
import com.example.book.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.book.utils.ResponseErrorCode.BAD_REQUEST;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    private MyUserRepository applicationUserRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    public UserController(MyUserRepository myUserRepository,
//                          BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.myUserRepository = myUserRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody MyUser user) {
        boolean result = userService.addUser(user);
        return Utils.getResponseEntity(result);
    }
}