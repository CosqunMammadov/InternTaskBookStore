package com.example.InternTaskBookStore.repository;

import com.example.InternTaskBookStore.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username =:username")
    User getByUsername(String username);
}
