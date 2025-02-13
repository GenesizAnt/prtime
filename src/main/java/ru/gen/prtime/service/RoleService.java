package ru.gen.prtime.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.entity.Role;
import ru.gen.prtime.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}