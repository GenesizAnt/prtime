package ru.gen.prtime.userAccessManagement.application.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
