package ru.gen.prtime.scheduleManagement.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Comment("Время специалиста доступное для оказания услуг")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedule_rule")
public class ScheduleRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
