package ru.gen.prtime.scheduleManagement.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import ru.gen.prtime.scheduleManagement.domainCalendarManaged.model.StatusTimeSlot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record OpenTimeWindowDto(
        Long timeSlotId,

        @NotNull
        LocalDate dateSlot,

        @NotNull
        LocalTime startTimeSlot,

        @NotNull
        LocalTime endTimeSlot,

        @NotBlank
        @Pattern(regexp = "^(MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY|SATURDAY|SUNDAY)$")
        String dayOfWeek,

        @NotNull
        StatusTimeSlot statusTimeSlot,

        @PastOrPresent
        LocalDateTime lockedAt,

        @NotNull
        Long specialistId
) {
}
