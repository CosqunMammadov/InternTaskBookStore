package com.example.InternTaskBookStore.repository;

import com.example.InternTaskBookStore.model.entity.Book;
import com.example.InternTaskBookStore.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s.booksRead FROM Student s WHERE s.id =:id")
    List<Book> getBooksRead(Long id);

    @Query("SELECT s FROM Student s WHERE s.id =:id")
    Student getById(Long id);

    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.booksRead b WHERE b.id=:id")
    List<Student> getReaders(Long id);
}
