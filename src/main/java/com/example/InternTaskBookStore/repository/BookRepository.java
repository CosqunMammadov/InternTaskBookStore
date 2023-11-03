package com.example.InternTaskBookStore.repository;

import com.example.InternTaskBookStore.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.author")
    List<Book> getAllBooks();

    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.author WHERE b.name =:name")
    Book getByName(String name);

     @Query("SELECT b FROM Book b LEFT JOIN FETCH b.author WHERE b.id =:id")
    Book getById(Long id);


}
