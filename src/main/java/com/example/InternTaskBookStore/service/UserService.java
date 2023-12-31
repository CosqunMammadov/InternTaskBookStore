package com.example.InternTaskBookStore.service;

import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.dto.response.UserResponseDto;
import com.example.InternTaskBookStore.model.entity.Role;
import com.example.InternTaskBookStore.model.entity.User;
import com.example.InternTaskBookStore.model.enums.ERole;
import com.example.InternTaskBookStore.model.mapper.UserMapper;
import com.example.InternTaskBookStore.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, RoleService roleService, @Lazy PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userMapper = userMapper;
    }

    public User register(SignUpRequestDto signUpRequestDto, ERole eRole){
        Role role = roleService.getByRoleName(eRole);
        User user = new User();
        user.setUsername(signUpRequestDto.getUsername());
        CharSequence password = signUpRequestDto.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return add(user);
    }

    public User add(User user){
        user.setActive(true);
        return userRepository.save(user);
    }

    public User getByUsername(String username){
        return userRepository.getByUsername(username);
    }

    public UserResponseDto getUserDataByUsername(String username){
        User user = getByUsername(username);
        return userMapper.userToUserResponseDto(user);
    }

}
