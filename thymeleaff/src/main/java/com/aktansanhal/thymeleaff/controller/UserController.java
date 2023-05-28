package com.aktansanhal.thymeleaff.controller;


import com.aktansanhal.thymeleaff.exception.exceptions.MyException;
import com.aktansanhal.thymeleaff.dto.UserResponseDTO;
import com.aktansanhal.thymeleaff.service.UserService;
import com.aktansanhal.thymeleaff.utilities.results.DataResult;
import com.aktansanhal.thymeleaff.utilities.results.Result;
import com.aktansanhal.thymeleaff.utilities.results.SuccessDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<DataResult<List<UserResponseDTO>>> getAllResults(){
        if(userService.gelAllUsers().isEmpty()){
            throw new MyException("kullanici bulunamadi");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessDataResult<>("liste",userService.gelAllUsers()));
    }






}
