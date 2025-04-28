package ru.gen.prtime.calendarManaged.application.mapper;

import jakarta.validation.Valid;
import org.springframework.stereotype.Component;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleDto;
import ru.gen.prtime.calendarManaged.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.scheduleManagement.shared.valueobjects.DailyWorkSchedule;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.util.List;

@Component
public class ScheduleRuleMapper {

    public ScheduleRuleEntity mapToEntity(@Valid AddScheduleRuleDto scheduleRule, User specialist) {
        ScheduleRuleEntity scheduleRuleEntity = new ScheduleRuleEntity();
        scheduleRuleEntity.setSpecialist(specialist);
        scheduleRuleEntity.setIsStatusBase(scheduleRule.isStatusBase());
        scheduleRuleEntity.setStartWorkTime(scheduleRule.dailyWorkSchedule().getStartWorkTime());
        scheduleRuleEntity.setEndWorkTime(scheduleRule.dailyWorkSchedule().getEndWorkTime());
        scheduleRuleEntity.setCountDaySet(scheduleRule.countDaySet());
        scheduleRuleEntity.setRestInterval(scheduleRule.dailyWorkSchedule().getRestInterval());
        scheduleRuleEntity.setBaseDurationAppointment(scheduleRule.dailyWorkSchedule().getBaseDurationAppointment());
        scheduleRuleEntity.setStartLunchTime(scheduleRule.dailyWorkSchedule().getStartLunchTime());
        scheduleRuleEntity.setEndLunchTime(scheduleRule.dailyWorkSchedule().getEndLunchTime());
        scheduleRuleEntity.setWeekendDay(String.join(";", scheduleRule.weekendDay()));
        scheduleRuleEntity.setDayOfWeekSet(String.join(";", scheduleRule.dayOfWeekSet()));
        return null;
    }

    public AddScheduleRuleDto mapToApi(ScheduleRuleEntity newScheduleRule) {
        return new AddScheduleRuleDto(
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
