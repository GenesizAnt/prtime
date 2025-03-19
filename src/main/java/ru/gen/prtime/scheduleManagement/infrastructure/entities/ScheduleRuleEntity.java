package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.scheduleManagement.domain.model.StatusScheduleRule;
import ru.gen.prtime.specialistServiceManagement.infrastructure.entities.SpecialistServicesEntity;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@Comment("Правила расписания специалиста")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule_rule")
public class ScheduleRuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_status_base")
    Boolean isStatusBase;

    @Column(name = "start_work_time")
    private LocalTime startWorkTime;

    @Column(name = "end_work_time")
    private LocalTime endWorkTime;

    @Column(name = "count_day_set")
    private Integer countDaySet;

    @Comment("Продолжительность перерыва между приемами")
    @Column(name = "rest_interval")
    private Duration restInterval;

    @Column(name = "base_duration_appointment")
    private Duration baseDurationAppointment;

    @Column(name = "start_lunch_time")
    private LocalTime startLunchTime;

    @Column(name = "end_lunch_time")
    private LocalTime endLunchTime;

    @Comment("Выходные дни")
    @Column(name = "weekend_day")
    private String weekendDay;

    @Comment("Дни недели для установки расписания")
    @Column(name = "day_week_set")
    private String dayOfWeekSet;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private User specialist;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "schedule_rules_specialist_services",
            joinColumns = @JoinColumn(name = "schedule_rule_id"),
            inverseJoinColumns = @JoinColumn(name = "specialist_services_entity_id")
    )
    private List<SpecialistServicesEntity> specialistServicesEntities;

    @ManyToMany(mappedBy = "scheduleRules", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CabinetEntity> cabinetEntityList;
}
