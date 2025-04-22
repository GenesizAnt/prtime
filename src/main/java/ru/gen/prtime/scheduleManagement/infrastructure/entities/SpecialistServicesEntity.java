package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Comment("Услуги, которые оказывает специалист")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialist_services")
public class SpecialistServicesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "description")
    private String description;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "is_actual")
    private Boolean isActual;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private User specialist;

    @OneToMany(mappedBy = "specialistService", cascade = CascadeType.ALL)
    private List<TimeSlot> appointments;

    @ManyToMany(mappedBy = "specialistServicesEntities", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ScheduleRuleEntity> scheduleRuleList;
}
