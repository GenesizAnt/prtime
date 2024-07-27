package ru.gen.prtime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionDTO {

    @NotNull(message = "Дата приема не может быть пустой")
    private LocalDate receptionDate;

    @NotNull(message = "Время приема не может быть пустым")
    private LocalTime receptionTime;
}