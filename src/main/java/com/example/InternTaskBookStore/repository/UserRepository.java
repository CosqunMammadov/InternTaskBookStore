package com.example.InternTaskBookStore.repository;

import com.example.InternTaskBookStore.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.booksRead b WHERE b.name =:bookName")
    List<User> getReaders(String bookName);
}
