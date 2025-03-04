package ru.gen.prtime.scheduleManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import ru.gen.prtime.userAccessManagement.security.entities.Role;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.util.Collection;

@Comment("Пространство, в котором специалист проводит приемы")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "сabinet_specialist")
public class CabinetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cabinet_name")
    private String cabinetName;

    @Column(name = "cabinet_address")
    private String cabinetAddress;

    @Column(name = "cabinet_description")
    private String cabinetDescription;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private User specialist;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "cabinets_schedule_rules",
            joinColumns = @JoinColumn(name = "сabinet_specialist_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_rule_id")
    )
    private Collection<ScheduleRuleEntity> scheduleRules;
}
