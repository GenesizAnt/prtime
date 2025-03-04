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
