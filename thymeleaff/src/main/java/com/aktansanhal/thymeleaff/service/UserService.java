package com.aktansanhal.thymeleaff.service;

import com.aktansanhal.thymeleaff.dto.UserResponseDTO;
import com.aktansanhal.thymeleaff.entity.User;
import com.aktansanhal.thymeleaff.mapper.UserMapper;
import com.aktansanhal.thymeleaff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserResponseDTO> gelAllUsers() {
        return userRepository.findAll().stream().map( user -> userMapper.userToResponseDto(user)).collect(Collectors.toList());
    }

    public UserResponseDTO getById(Long id) {
        return userMapper.userToResponseDto(userRepository.findById(id).orElseThrow());
    }
}
