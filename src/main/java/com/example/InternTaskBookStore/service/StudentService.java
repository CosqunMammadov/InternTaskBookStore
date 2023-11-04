package com.example.InternTaskBookStore.service;

import com.example.InternTaskBookStore.model.dto.request.SignUpRequestDto;
import com.example.InternTaskBookStore.model.dto.response.BookResponseDto;
import com.example.InternTaskBookStore.model.dto.response.StudentResponseDto;
import com.example.InternTaskBookStore.model.entity.Book;
import com.example.InternTaskBookStore.model.entity.Student;
import com.example.InternTaskBookStore.model.entity.User;
import com.example.InternTaskBookStore.model.enums.ERole;
import com.example.InternTaskBookStore.model.mapper.BookMapper;
import com.example.InternTaskBookStore.model.mapper.StudentMapper;
import com.example.InternTaskBookStore.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final UserService userService;
    private final BookMapper bookMapper;
    private final AuthorService authorService;
    private final BookService bookService;

    @Transactional(rollbackFor = RuntimeException.class)
    public Student register(SignUpRequestDto signUpRequestDto){
        User user = userService.register(signUpRequestDto, ERole.ROLE_STUDENT);
        Student student = studentMapper.signUpRequestDtoToStudent(signUpRequestDto);
        student.setUser(user);
        return add(student);
    }

    public Student add(Student student){
        return studentRepository.save(student);
    }

    public List<BookResponseDto> getBooksRead(Long id){
        List<Book> books = studentRepository.getBooksRead(id);
        List<BookResponseDto> bookResponseDtoList = new LinkedList<>();
        books.forEach(book -> bookResponseDtoList.add(bookMapper.bookToBookResponseDto(book)));
        return bookResponseDtoList;
    }

    public List<StudentResponseDto> getReaders(Long bookId){
        List<Student> students = studentRepository.getReaders(bookId);
        List<StudentResponseDto> studentResponseDtoList = new LinkedList<>();
        students.forEach(student -> studentResponseDtoList.add(studentMapper.studentToStudentResponseDto(student)));
        return studentResponseDtoList;
    }

    public void addToReadBooks(Long studentId, Long bookId){
        Book book = bookService.getById(bookId);
        Student student = studentRepository.getById(studentId);
        Set<Book> books = student.getBooksRead();
        if (books == null)
            books = new HashSet<>();
        books.add(book);
        studentRepository.save(student);
    }

    public void subscribe(Long authorId, Long studentId){
        Student student = studentRepository.getById(studentId);
        authorService.setSubscribe(authorId, student);
    }
}
