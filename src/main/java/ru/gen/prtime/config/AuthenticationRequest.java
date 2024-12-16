package ru.gen.prtime.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;
}
