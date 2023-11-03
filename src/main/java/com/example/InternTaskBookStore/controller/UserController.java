package com.example.InternTaskBookStore.controller;

import com.example.InternTaskBookStore.model.dto.response.UserResponseDto;
import com.example.InternTaskBookStore.model.entity.User;
import com.example.InternTaskBookStore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get-readers/{bookName}")
    public List<UserResponseDto> getReaders(@PathVariable String bookName){
        return userService.getReaders(bookName);
    }
}
