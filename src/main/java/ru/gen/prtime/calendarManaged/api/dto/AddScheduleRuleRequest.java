package ru.gen.prtime.calendarManaged.api.dto;

import jakarta.validation.constraints.NotNull;
import ru.gen.prtime.scheduleManagement.shared.valueobjects.DailyWorkSchedule;

import java.util.List;

public record AddScheduleRuleRequest(
        @NotNull
        Long scheduleRuleId,
        @NotNull
        Long specialistId,
        @NotNull
        String ruleName,
        @NotNull
        Boolean statusScheduleRule,
        @NotNull
        DailyWorkSchedule dailyWorkSchedule,
        @NotNull
        Integer countDaySet,
        @NotNull
        List<String> weekendDay,
        @NotNull
        List<String> dayOfWeekSet
//        @NotNull
//        Long specialistId,
//
//        @NotNull
//        Boolean isStatusBase,
//
//        @NotNull
//        String ruleName,
//
//        @NotNull
//        LocalTime startWorkTime,
//
//        @NotNull
//        LocalTime endWorkTime,
//
//        @NotNull
//        @Positive
//        Duration restInterval,
//
//        @NotNull
//        @Positive
//        Duration baseDurationAppointment,
//
//        @NotNull
//        LocalTime startLunchTime,
//
//        @NotNull
//        LocalTime endLunchTime,
//
//        @NotNull
//        @Min(value = 1)
//        Integer countDaySet,
//
//        @NotNull
//        @Size(max = 7)
//        List<String> weekendDay,
//
//        @NotNull
//        @Size(min = 1, max = 7)
//        List<String> dayOfWeekSet,

//        @NotNull
//        @Size(min = 1)
//        List<Long> availableServiceList,

//        @NotNull
//        @Size(min = 1)
//        List<Long> cabinetList
) {

}
