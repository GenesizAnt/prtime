package ru.gen.prtime.userAccessManagement.security.entities;

import jakarta.persistence.*;
import lombok.Data;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.CalendarEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.UnregisteredUser;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "username")
//    private String username;

    @Column(name = "password")
    private String password;

    //VO - Email
    @Column(name = "email")
    private String email;
    //

    //VO - phoneNumber
    @Column(name = "phone_number")
    private String phoneNumber;
    //

    //VO - birthday
    @Column(name = "birthday")
    private LocalDate birthday;
    //

//    @Embedded
//    private UserFullName userFullName;

    //VO - UserFullName
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;
    //

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<TimeSlot> clientTimeSlots;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<TimeSlot> specialistTimeSlots;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<CalendarEntity> specialistCalendars;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<UnregisteredUser> unregisteredUsers;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;

    /*
    // Методы для преобразования в доменную модель и обратно
    public User toDomain() {
        return new User(this.id, this.username, this.email);
    }

    public static UserEntity fromDomain(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        return entity;
    }
     */

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
}