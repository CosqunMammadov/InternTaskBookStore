package com.example.InternTaskBookStore.model.mapper;

import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.dto.response.UserResponseDto;
import com.example.InternTaskBookStore.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User signUpRequestDtoToUser(SignUpRequestDto signUpRequestDto);
    UserResponseDto userToUserResponseDto(User user);
}
