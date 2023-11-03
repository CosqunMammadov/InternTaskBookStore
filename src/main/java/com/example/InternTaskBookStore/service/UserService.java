package com.example.InternTaskBookStore.service;

import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.dto.response.UserResponseDto;
import com.example.InternTaskBookStore.model.entity.Role;
import com.example.InternTaskBookStore.model.entity.User;
import com.example.InternTaskBookStore.model.enums.ERole;
import com.example.InternTaskBookStore.model.mapper.UserMapper;
import com.example.InternTaskBookStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;

    public User register(SignUpRequestDto signUpRequestDto, ERole eRole){
        Role role = roleService.getByRoleName(eRole);
        User user = userMapper.signUpRequestDtoToUser(signUpRequestDto);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return add(user);
    }

    public User add(User user){
        user.setActive(true);
        return userRepository.save(user);
    }

    public List<UserResponseDto> getReaders(String bookName){
        List<User> users =  userRepository.getReaders(bookName);
        List<UserResponseDto> userResponseDtoList = new LinkedList<>();
        users.forEach( user -> userResponseDtoList.add(userMapper.userToUserResponseDto(user)));
        return userResponseDtoList;
    }
}
