package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.specialistServiceManagement.infrastructure.entities.SpecialistServicesEntity;
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

    //ToDo нужен отдельный раздел уведомления/сообщениями в приложении

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_slot")
    private LocalDate dateSlot;

    @Column(name = "start_time_slot")
    private LocalTime startTimeSlot;

    @Column(name = "end_time_slot")
    private LocalTime endTimeSlot;

    @Column(name = "day_week")
    private String dayOfWeek;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_appointment")
    private StatusAppointment statusAppointment;

    @Column(name = "is_primary_visit")
    private Boolean isPrimaryVisit;

    @Column(name = "is_need_confirm_client")
    private Boolean isNeedConfirmClient;

    @Column(name = "is_confirm_client")
    private Boolean isConfirmClient;

    @Column(name = "is_confirm_specialist")
    private Boolean isConfirmSpecialist;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_slot")
    private StatusTimeSlot statusTimeSlot;

    //ToDo сделать job который будет снимать блокировку через 10 мин после начала блокировки (к примеру)
    @Comment("Время блокировки слота для операций")
    @Column(name = "locked_at")
    private LocalDateTime lockedAt;

//    @Column(name = "cabinet_name")
//    private String cabinetName;
//
//    @Column(name = "cabinet_address")
//    private String cabinetAddress;
//
//    @Column(name = "cabinet_description")
//    private String cabinetDescription;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Column(name = "register_app_client")
    private Boolean statusRegistrationClient;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private User specialist;

    @ManyToOne
    @JoinColumn(name = "specialistService_id")
    private SpecialistServicesEntity specialistService;

    @ManyToOne
    @JoinColumn(name = "cabinet_id")
    private CabinetEntity cabinet;
}
