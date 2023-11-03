package com.example.InternTaskBookStore.model.dto.response;

import com.example.InternTaskBookStore.model.entity.Book;
import com.example.InternTaskBookStore.model.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponseDto {

    String name;
    String email;
    int age;
    Set<Book> writtenBooks;
    Set<Student> subscribers;
}
