package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Comment("Правила расписания специалиста")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule_rule")
public class ScheduleRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private CalendarEntity calendarEntity;
}
