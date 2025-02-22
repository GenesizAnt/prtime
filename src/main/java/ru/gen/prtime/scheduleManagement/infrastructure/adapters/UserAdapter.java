package ru.gen.prtime.scheduleManagement.infrastructure.adapters;

import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    // пример как делать интеграцию с другими доменами

//    private final UserService userService; // Сервис из домена userAccessManagement
//
//    public UserAdapterImpl(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public Client getClientById(UserId userId) {
//        User user = userService.getUserById(userId); // Получаем данные из userAccessManagement
//        return new Client(user.getId(), user.getName(), user.getEmail());
//    }
}
