package ru.gen.prtime.userAccessManagement.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.userAccessManagement.security.entities.Role;
import ru.gen.prtime.userAccessManagement.security.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}