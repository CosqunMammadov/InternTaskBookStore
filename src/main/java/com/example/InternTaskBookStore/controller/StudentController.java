package com.example.InternTaskBookStore.controller;


import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.dto.response.BookResponseDto;
import com.example.InternTaskBookStore.model.dto.response.StudentResponseDto;
import com.example.InternTaskBookStore.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('STUDENT')")
    public List<BookResponseDto> getBooksRead(@PathVariable Long id){
        return studentService.getBooksRead(id);
    }

    @GetMapping("/get-readers/{bookId}")
    @PreAuthorize("hasAnyRole('AUTHOR', 'STUDENT')")
    public List<StudentResponseDto> getReaders(@PathVariable Long bookId){
        return studentService.getReaders(bookId);
    }

    @PatchMapping("/subscribe/{authorId}/{studentId}")
    @PreAuthorize("hasRole('STUDENT')")
    public void subscribe(@PathVariable Long authorId, @PathVariable Long studentId){
        studentService.subscribe(authorId, studentId);
    }

    @PatchMapping("/add-to-read-books/{studentId}/{bookId}")
    @PreAuthorize("hasRole('STUDENT')")
    public void adToReadBooks(@PathVariable Long studentId, @PathVariable Long bookId){
        studentService.addToReadBooks(studentId, bookId);
    }
}
