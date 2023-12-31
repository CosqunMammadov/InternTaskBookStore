package com.example.InternTaskBookStore.service;

import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.dto.response.BookResponseDto;
import com.example.InternTaskBookStore.model.entity.Author;
import com.example.InternTaskBookStore.model.entity.Book;
import com.example.InternTaskBookStore.model.entity.Student;
import com.example.InternTaskBookStore.model.entity.User;
import com.example.InternTaskBookStore.model.enums.ERole;
import com.example.InternTaskBookStore.model.mapper.AuthorMapper;
import com.example.InternTaskBookStore.model.mapper.BookMapper;
import com.example.InternTaskBookStore.repository.AuthorRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final UserService userService;
    private final BookService bookService;
    private final BookMapper bookMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper, UserService userService,
                         @Lazy BookService bookService, BookMapper bookMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.userService = userService;
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public Author register(SignUpRequestDto signUpRequestDto){
        User user = userService.register(signUpRequestDto, ERole.ROLE_AUTHOR);
        Author author = authorMapper.signUpRequestDtoToAuthor(signUpRequestDto);
        author.setUser(user);
        return add(author);
    }

    public Author add(Author author){
        return authorRepository.save(author);
    }

    public Author getById(Long authorId){
        return authorRepository.getById(authorId);
    }

    public List<Student> getSubscribers(Long id){
        return authorRepository.getSubscribers(id);
    }

    public List<BookResponseDto> getWrittenBooks(Long authorId){
        List<Book> books = bookService.getBooksByAuthorId(authorId);
        List<BookResponseDto> bookResponseDtoList = new LinkedList<>();
        books.forEach(book -> bookResponseDtoList.add(bookMapper.bookToBookResponseDto(book)));
        return bookResponseDtoList;
    }

    public void setSubscribe(Long authorId, Student student){
        Author author = authorRepository.getById(authorId);
        Set<Student> subscribers = author.getSubscribers();
        if (subscribers == null)
            subscribers = new HashSet<>();
        subscribers.add(student);
        authorRepository.save(author);
    }

}
