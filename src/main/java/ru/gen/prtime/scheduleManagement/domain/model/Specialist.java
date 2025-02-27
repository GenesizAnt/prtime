package ru.gen.prtime.scheduleManagement.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.PersonFullName;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.CalendarEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.UnregisteredUser;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Specialist {
    private Long id;
    //VO - Email
    private String email;
    //
    //VO - phoneNumber
    private String phoneNumber;
    //
    private PersonFullName fullName;
    private List<Client> clients;


    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<TimeSlot> clientTimeSlots;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<TimeSlot> specialistTimeSlots;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<CalendarEntity> specialistCalendars;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<UnregisteredUser> unregisteredUsers;
}
