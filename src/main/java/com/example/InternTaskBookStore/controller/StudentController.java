package com.example.InternTaskBookStore.controller;


import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.dto.response.BookResponseDto;
import com.example.InternTaskBookStore.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid SignUpRequestDto signUpRequestDto){
        studentService.register(signUpRequestDto);
    }

    @GetMapping("/get-books-read/{id}")
    public List<BookResponseDto> getBooksRead(@PathVariable Long id){
        return studentService.getBooksRead(id);
    }
}
