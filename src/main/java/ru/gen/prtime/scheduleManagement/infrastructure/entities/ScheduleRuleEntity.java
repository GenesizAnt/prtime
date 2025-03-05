package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.scheduleManagement.domain.model.StatusScheduleRule;
import ru.gen.prtime.userAccessManagement.security.entities.Role;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collection;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "status_schedule")
    private StatusScheduleRule statusScheduleRule;

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
    private Duration baseDurationAppointment; //ToDo https://qaa-engineer.ru/kak-ispolzovat-tip-interval-v-postgresql/

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
}
