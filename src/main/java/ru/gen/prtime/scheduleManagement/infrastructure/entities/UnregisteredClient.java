package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.specialistAdministrationWork.infrastructure.entities.SpecialistClientRelation;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Comment("Незарегистрированные в приложении клиенты, создаются специалистом")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unregistered_client")
public class UnregisteredClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "unregisteredClient")
    private SpecialistClientRelation unregisteredClientRelation;
}
