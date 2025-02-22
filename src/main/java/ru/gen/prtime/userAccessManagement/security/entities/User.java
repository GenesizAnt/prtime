package ru.gen.prtime.userAccessManagement.security.entities;

import jakarta.persistence.*;
import lombok.Data;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;

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

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;
}