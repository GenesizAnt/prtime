package ru.gen.prtime.scheduleManagement.infrastructure.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.gen.prtime.scheduleManagement.domain.model.Specialist;
import ru.gen.prtime.userAccessManagement.security.entities.User;
import ru.gen.prtime.userAccessManagement.security.service.UserService;

@Component
@RequiredArgsConstructor
public class UserAdapter {

    private final UserService userService;

    public Specialist getSpecialistById(Long userId) {
        User user = userService.getUserById(userId).orElseThrow(() -> new UsernameNotFoundException(
                String.format("Пользователь с id: '%s' не найден", userId)
        ));
        return new Specialist(user);
    }
}

