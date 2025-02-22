package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.List;

@Comment("Сущность календаря специалиста для хранения временных слотов")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<TimeSlot> timeSlot;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<ScheduleRule> scheduleRules;
}
