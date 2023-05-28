package com.aktansanhal.thymeleaff.controller;


import com.aktansanhal.thymeleaff.entity.UserDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDetailController {

    private UserDetailRepository userDetailRepository;

    public UserDetailController(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @PostMapping("/userdetail")
    public UserDetail saveUserDetail(@RequestBody UserDetail userDetail){
        return userDetailRepository.save(userDetail);
    }

    @GetMapping("/userdetail")
    public List<UserDetail> getAllUserDetail(){
        return userDetailRepository.findAll();
    }
}
