package ru.gen.prtime.calendarManaged.application.mapper;

import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleRequest;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleResponse;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.scheduleManagement.shared.valueobjects.DailyWorkSchedule;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.util.List;

@Component
public class ScheduleRuleMapper {
//    public AddScheduleRuleResponse mapToApi(ScheduleRule saveScheduleRule) {
//        return null;
//    }

    public ScheduleRuleEntity mapToEntity(@Valid AddScheduleRuleRequest scheduleRuleRequest, User specialist) {
        ScheduleRuleEntity scheduleRuleEntity = new ScheduleRuleEntity();
        scheduleRuleEntity.setSpecialist(specialist);
        scheduleRuleEntity.setIsStatusBase(scheduleRuleRequest.statusScheduleRule());
        scheduleRuleEntity.setStartWorkTime(scheduleRuleRequest.dailyWorkSchedule().getStartWorkTime());
        scheduleRuleEntity.setEndWorkTime(scheduleRuleRequest.dailyWorkSchedule().getEndWorkTime());
        scheduleRuleEntity.setCountDaySet(scheduleRuleRequest.countDaySet());
        scheduleRuleEntity.setRestInterval(scheduleRuleRequest.dailyWorkSchedule().getRestInterval());
        scheduleRuleEntity.setBaseDurationAppointment(scheduleRuleRequest.dailyWorkSchedule().getBaseDurationAppointment());
        scheduleRuleEntity.setStartLunchTime(scheduleRuleRequest.dailyWorkSchedule().getStartLunchTime());
        scheduleRuleEntity.setEndLunchTime(scheduleRuleRequest.dailyWorkSchedule().getEndLunchTime());
        scheduleRuleEntity.setWeekendDay(String.join(";", scheduleRuleRequest.weekendDay()));
        scheduleRuleEntity.setDayOfWeekSet(String.join(";", scheduleRuleRequest.dayOfWeekSet()));
        return null;
    }

    public AddScheduleRuleResponse mapToApi(ScheduleRuleEntity newScheduleRule) {
        return new AddScheduleRuleResponse(
                newScheduleRule.getId(),
                newScheduleRule.getSpecialist().getId(),
                newScheduleRule.getRuleName(),
                newScheduleRule.getIsStatusBase(),
                new DailyWorkSchedule(newScheduleRule),
                newScheduleRule.getCountDaySet(),
                List.of(newScheduleRule.getDayOfWeekSet().split(";")),
                List.of(newScheduleRule.getDayOfWeekSet().split(";"))
        );
    }
}
