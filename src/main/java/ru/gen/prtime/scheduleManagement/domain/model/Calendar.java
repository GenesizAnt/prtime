package ru.gen.prtime.scheduleManagement.domain.model;

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
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<TimeSlot> timeSlot;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ScheduleRule> scheduleRules;
}
