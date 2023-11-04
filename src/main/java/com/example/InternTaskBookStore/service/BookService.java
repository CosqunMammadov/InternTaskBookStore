package com.example.InternTaskBookStore.service;

import com.example.InternTaskBookStore.model.dto.request.BookRequestDto;
import com.example.InternTaskBookStore.model.dto.response.BookResponseDto;
import com.example.InternTaskBookStore.model.entity.Author;
import com.example.InternTaskBookStore.model.entity.Book;
import com.example.InternTaskBookStore.model.entity.Student;
import com.example.InternTaskBookStore.model.mapper.BookMapper;
import com.example.InternTaskBookStore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final EmailService emailService;

    public Book add(Long authorId, BookRequestDto bookRequestDto){
        Author author = authorService.getById(authorId);
        Book book = bookMapper.bookRequestDtoToBook(bookRequestDto);
        book.setAuthor(author);
        sendNotification(author, book);
        return bookRepository.save(book);
    }

    public void sendNotification(Author author, Book book){
        List<Student> subscribers = authorService.getSubscribers(author.getId());
        String[] emails = getSubscribersEmail(subscribers);
        String subject = "A new book was published.";
        String text = String.format("A writer called %s published a new book called %s", author.getName(), book.getName());
        emailService.sendEmail(emails, subject, text);
    }

    public BookResponseDto getByName(String name){
        return bookMapper.bookToBookResponseDto(bookRepository.getByName(name));
    }

    public Book getById(Long id){
        return bookRepository.getById(id);
    }

    public List<BookResponseDto> getAllBooks(){
        List<Book> books = bookRepository.getAllBooks();
        List<BookResponseDto> bookResponseDtoList = new LinkedList<>();
        books.forEach(book -> bookResponseDtoList.add(bookMapper.bookToBookResponseDto(book)));
        return bookResponseDtoList;
    }

    public List<Book> getBooksByAuthorId(Long authorId){
        return bookRepository.getBooksByAuthorId(authorId);
    }

    public void delete(Long bookId){
        Book book = bookRepository.getById(bookId);
        bookRepository.delete(book);
    }

    public String[] getSubscribersEmail(List<Student> subscribers){
        List<String> emailList = new ArrayList<>();
        subscribers.forEach(student -> emailList.add(student.getEmail()));
        String[] emails = emailList.toArray(new String[emailList.size()]);
        return emails;
    }
}
