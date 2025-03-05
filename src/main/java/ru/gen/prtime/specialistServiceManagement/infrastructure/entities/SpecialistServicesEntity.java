package ru.gen.prtime.specialistServiceManagement.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.Duration;
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

    @Column(name = "special_tariff")
    @Enumerated(EnumType.STRING)
    private TypeTariff typeTariff; //ToDo базовая услуга, акция

    // @Column(name = "special_tariff")
    @Enumerated(EnumType.STRING)
    private TypeTariff typeTariff; //ToDo первичный, вторичный is_primary_visit

    //ToDo список Акций, которые есть у услуги - private Integer discount;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person ownerService;

    @OneToMany(mappedBy = "professionalServices")
    private List<SpecialistAppointments> listServicesRendered;
}
