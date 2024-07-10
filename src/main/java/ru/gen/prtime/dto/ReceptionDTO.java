package ru.gen.prtime.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionDTO {
    private Integer idSpecialist;

    private Integer idVisitor;

    private String receptionDate;

    private String receptionTime;
}
