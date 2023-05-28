package com.aktansanhal.thymeleaff.mapper;


import com.aktansanhal.thymeleaff.dto.UserRequestDTO;
import com.aktansanhal.thymeleaff.dto.UserResponseDTO;
import com.aktansanhal.thymeleaff.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User requestToUser(UserRequestDTO userRequestDTO);
    UserRequestDTO userToRequestDTO(User user);

    User responseDtoToUser(UserResponseDTO userResponseDTO);
    UserResponseDTO userToResponseDto(User user);
}
