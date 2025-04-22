package ru.gen.prtime.scheduleManagement.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

public record AddScheduleRuleInput(
        @NotNull
        Long specialistId,

        @NotNull
        Boolean isStatusBase,

        @NotNull
        LocalTime startWorkTime,

        @NotNull
        LocalTime endWorkTime,

        @NotNull
        @Positive
        Duration restInterval,

        @NotNull
        @Positive
        Duration baseDurationAppointment,

        @NotNull
        LocalTime startLunchTime,

        @NotNull
        LocalTime endLunchTime,

        @NotNull
        @Min(value = 1)
        Integer countDaySet,

        @NotNull
        @Size(max = 7)
        List<String> weekendDay,

        @NotNull
        @Size(min = 1, max = 7)
        List<String> dayOfWeekSet,

        @NotNull
        @Size(min = 1)
        List<Long> availableServiceList,

        @NotNull
        @Size(min = 1)
        List<Long> cabinetList
) {
}
