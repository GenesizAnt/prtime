package ru.gen.prtime.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionDTO {

    private LocalDate receptionDate;

    private LocalTime receptionTime;
}
