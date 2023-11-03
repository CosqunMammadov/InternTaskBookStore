package com.example.InternTaskBookStore.controller;

import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.dto.response.BookResponseDto;
import com.example.InternTaskBookStore.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid SignUpRequestDto signUpRequestDto){
        authorService.register(signUpRequestDto);
    }

//    @GetMapping("/get-written-books/{id}")
//    public List<BookResponseDto> getWrittenBooks(@PathVariable Long id){
//        return authorService.getWrittenBooks(id);
//    }

    @DeleteMapping("/delete-book/{authorId}/{bookId}")
    public void deleteWrittenBook(@PathVariable Long authorId, @PathVariable Long bookId){
        authorService.deleteWrittenBook(authorId, bookId);
    }
}
