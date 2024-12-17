package ru.gen.prtime.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gen.prtime.entity.UserApp;

import java.util.Optional;

public interface UserAppRepository extends CrudRepository<UserApp, Integer> {

    Optional<UserApp> findByUsername(String username);
}
