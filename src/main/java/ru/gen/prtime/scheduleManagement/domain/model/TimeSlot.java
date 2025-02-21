package ru.gen.prtime.scheduleManagement.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.entity.User;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.DateTimeAppointment;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.UserFullName;

import java.time.LocalDate;
import java.time.LocalTime;

@Comment("Время специалиста доступное для оказания услуг")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "time_slot")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private DateTimeAppointment dateTimeAppointment;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_appointment")
    private StatusAppointment statusAppointment;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_slot")
    private StatusTimeSlot statusTimeSlot;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User visitor;

    @Column(name = "register_visitor")
    private Boolean statusRegistration;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private User specialist;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;
}
