package com.example.InternTaskBookStore.repository;

import com.example.InternTaskBookStore.model.entity.Author;
import com.example.InternTaskBookStore.model.entity.Book;
import com.example.InternTaskBookStore.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.writtenBooks LEFT JOIN FETCH a.subscribers " +
            "LEFT JOIN FETCH a.user WHERE a.id = :id")
    Author getById(Long id);

//    @Query("SELECT a.writtenBooks FROM Author a JOIN FETCH a.writtenBooks WHERE a.id =:id")
//    List<Book> getWrittenBooks(Long id);

    @Query("SELECT a.subscribers FROM Author a WHERE a.id =:id")
    List<Student> getSubscribers(Long id);
}
