package ru.gen.prtime.userAccessManagement.security.entities;

import jakarta.persistence.*;
import lombok.Data;
import ru.gen.prtime.scheduleManagement.domain.model.Client;
import ru.gen.prtime.scheduleManagement.domain.model.Specialist;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.Email;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.PersonFullName;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.PhoneNumber;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.CabinetEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.UnregisteredClient;

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

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<TimeSlot> clientTimeSlots;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<TimeSlot> specialistTimeSlots;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<ScheduleRuleEntity> scheduleRuleEntities;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<UnregisteredClient> unregisteredClients;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<CabinetEntity> cabinets;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;
}