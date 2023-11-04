package com.example.InternTaskBookStore.controller;


import com.example.InternTaskBookStore.model.dto.request.BookRequestDto;
import com.example.InternTaskBookStore.model.dto.response.BookResponseDto;
import com.example.InternTaskBookStore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/add-book/{authorId}")
    @PreAuthorize("hasRole('AUTHOR')")
    public void add(@PathVariable Long authorId, @RequestBody BookRequestDto bookRequestDto){
        bookService.add(authorId, bookRequestDto);
    }

    @GetMapping("/get-by-name/{name}")
    @PreAuthorize("hasAnyRole('STUDENT', 'AUTHOR')")
    public BookResponseDto getByName(@PathVariable String name){
        return bookService.getByName(name);
    }

    @GetMapping("/all-books")
    @PreAuthorize("hasAnyRole('STUDENT', 'AUTHOR')")
    public List<BookResponseDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @DeleteMapping("/delete-book/{id}")
    @PreAuthorize("hasRole('AUTHOR')")
    public void deletBook(@PathVariable("id") Long bookId){
        bookService.delete(bookId);
    }
}
