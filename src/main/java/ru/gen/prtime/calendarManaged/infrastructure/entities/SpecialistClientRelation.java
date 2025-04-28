package ru.gen.prtime.calendarManaged.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.time.LocalDateTime;

@Comment("Список клиентов зафиксированных за специалистом")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "secialist_client_relation")
public class SpecialistClientRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private User specialist;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToOne
    @JoinColumn(name = "unregistered_client_id")
    private UnregisteredClient unregisteredClient;

    @Column(name = "is_registered")
    private Boolean isRegistered;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
