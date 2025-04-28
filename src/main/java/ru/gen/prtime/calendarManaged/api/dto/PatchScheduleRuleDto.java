package ru.gen.prtime.calendarManaged.api.dto;

import ru.gen.prtime.scheduleManagement.shared.valueobjects.DailyWorkSchedule;

import java.util.List;

public record PatchScheduleRuleDto(
        Long scheduleRuleId,
        Long specialistId,
        String ruleName,
        Boolean isStatusBase,
        DailyWorkSchedule dailyWorkSchedule,
        Integer countDaySet,
        List<String> weekendDay,
        List<String> dayOfWeekSet
) {}
//        @NotNull
//        Long scheduleRuleId,
//
//        @NotNull
//        Long specialistId,
//
//        @NotNull
//        Boolean isStatusBase,
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
//        List<String> dayOfWeekSet

//        @NotNull
//        @Size(min = 1)
//        List<Long> availableServiceList,
//
//        @NotNull
//        @Size(min = 1)
//        List<Long> cabinetList
//) {
//}
