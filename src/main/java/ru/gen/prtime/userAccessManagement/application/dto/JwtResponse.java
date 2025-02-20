package ru.gen.prtime.userAccessManagement.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String username;
    private Collection<GrantedAuthority> authorities;
}