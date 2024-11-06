package ru.gen.prtime.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.web.bind.annotation.Mapping;
//import org.aspectj.lang.annotation.Around;
//import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalTime;

@Comment("Таблица приемов у специалиста")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reception")
public class Reception {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reception_date")
    private LocalDate receptionDate;

    @Column(name = "reception_time")
    private LocalTime receptionTime;

}
