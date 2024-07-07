package ru.gen.prtime.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.aspectj.lang.annotation.Around;
//import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalTime;

//@Comment("Таблица приемов у специалиста")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reception {

    private Integer id;

    private Integer idSpecialist;

    private LocalDate receptionDate;

    private LocalTime receptionTime;

}
