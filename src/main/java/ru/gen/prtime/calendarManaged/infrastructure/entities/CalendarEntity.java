package ru.gen.prtime.calendarManaged.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.util.List;

@Comment("Сущность календаря специалиста для хранения временных слотов")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "calendar")
public class CalendarEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private User specialist;

}
