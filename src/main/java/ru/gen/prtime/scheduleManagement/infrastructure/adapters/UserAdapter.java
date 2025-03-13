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

    // пример как делать интеграцию с другими доменами

//    private final UserService userService; // Сервис из домена userAccessManagement
//
//    @Override
//    public Client getClientById(UserId userId) {
//        User user = userService.getUserById(userId); // Получаем данные из userAccessManagement
//        return new Client(user.getId(), user.getName(), user.getEmail());
//    }
}

/*
/*
    @Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return jpaUserRepository.findById(id).map(UserEntity::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserEntity.fromDomain(user);
        return jpaUserRepository.save(entity).toDomain();
    }

    @Override
    public void delete(User user) {
        UserEntity entity = UserEntity.fromDomain(user);
        jpaUserRepository.delete(entity);
    }
     */
