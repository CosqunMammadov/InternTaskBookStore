package com.example.InternTaskBookStore.repository;

import com.example.InternTaskBookStore.model.entity.Author;
import com.example.InternTaskBookStore.model.entity.Book;
import com.example.InternTaskBookStore.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.subscribers " +
            "LEFT JOIN FETCH a.user  WHERE a.id =:id")
    Author getById(Long id);

    @Query("SELECT a.subscribers FROM Author a WHERE a.id =:id")
    List<Student> getSubscribers(Long id);

    @Query("DELETE FROM Book b WHERE b.id =:book AND b.author.id =:author")
    void deleteWrittenBook(@Param("book") Long bookId, @Param("author") Long authorId);
}
