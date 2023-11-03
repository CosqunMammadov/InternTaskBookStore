package com.example.InternTaskBookStore.repository;

import com.example.InternTaskBookStore.model.entity.Role;
import com.example.InternTaskBookStore.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT r FROM Role r WHERE r.roleName =:roleName")
    Role getByRoleName(@Param(value = "roleName") ERole eRole);
}
