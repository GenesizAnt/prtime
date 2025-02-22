package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Comment("Незарегистрированные в приложении клиенты")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unregistered_user")
public class UnregisteredUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
