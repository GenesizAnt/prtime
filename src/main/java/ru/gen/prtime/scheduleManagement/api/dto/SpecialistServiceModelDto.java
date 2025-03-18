package ru.gen.prtime.scheduleManagement.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record SpecialistServiceModelDto(
        Long serviceId,

        @NotNull
        String serviceName,

        @NotNull
        String description,

        @NotNull
        String shortDescription,

        @NotNull
        @Positive
        BigDecimal price
) {
}
