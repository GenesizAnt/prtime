package ru.gen.prtime.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionDTO {

    private Integer id;

    @Size(min = 10, max = 10)
    private LocalDate receptionDate;

    @Size(min = 5, max = 5)
    @NotNull
    private LocalTime receptionTime;
}
