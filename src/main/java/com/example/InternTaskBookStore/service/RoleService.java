package com.example.InternTaskBookStore.service;

import com.example.InternTaskBookStore.model.entity.Role;
import com.example.InternTaskBookStore.model.enums.ERole;
import com.example.InternTaskBookStore.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getByRoleName(ERole eRole){
        return roleRepository.getByRoleName(eRole);
    }
}
