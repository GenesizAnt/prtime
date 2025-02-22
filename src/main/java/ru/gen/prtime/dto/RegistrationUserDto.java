package ru.gen.prtime.dto;

import lombok.Data;

@Data
public class RegistrationUserDto {
    private String password;
    private String confirmPassword;
    private String email;
}