package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.userAccessManagement.security.entities.User;
import ru.gen.prtime.scheduleManagement.domain.model.StatusAppointment;
import ru.gen.prtime.scheduleManagement.domain.model.StatusTimeSlot;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

//    @Embedded
//    private DateTimeAppointment dateTimeAppointment;

    //VO - DateTimeAppointment
    @Column(name = "date_slot")
    private LocalDate dateSlot;

    @Column(name = "start_time_slot")
    private LocalTime startTimeSlot;

    @Column(name = "end_time_slot")
    private LocalTime endTimeSlot;

    @Column(name = "day_week")
    private String dayOfWeek;
    //

    @Enumerated(EnumType.STRING)
    @Column(name = "status_appointment")
    private StatusAppointment statusAppointment;

    @Column(name = "register_app_client")
    private Boolean statusRegistration;

    //ToDo сделать job который будет снимать блокировку через 10 мин после начала блокировки (к примеру)
    @Column(name = "locked_at")
    private LocalDateTime lockedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_slot")
    private StatusTimeSlot statusTimeSlot;

    //VO @Comment("Пространство, в котором специалист проводит приемы")
    @Column(name = "cabinet_name")
    private String cabinetName;

    @Column(name = "cabinet_address")
    private String cabinetAddress;

    @Column(name = "cabinet_description")
    private String cabinetDescription;
    //

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private User specialist;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private CalendarEntity calendar;
}
