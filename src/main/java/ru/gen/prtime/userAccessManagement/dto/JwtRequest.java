package ru.gen.prtime.userAccessManagement.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String email;
    private String password;
}
