package ru.gen.prtime.scheduleManagement.infrastructure.mapper;

import org.springframework.stereotype.Component;
import ru.gen.prtime.scheduleManagement.domainCalendarManaged.model.ScheduleRule;
import ru.gen.prtime.scheduleManagement.domainCalendarManaged.model.StatusScheduleRule;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.util.stream.Collectors;

@Component
public class ScheduleRuleInfraMapper {

    public ScheduleRuleEntity mapToORM(User specialist, ScheduleRule scheduleRule) {
        ScheduleRuleEntity scheduleRuleEntity = new ScheduleRuleEntity();
        scheduleRuleEntity.setSpecialist(specialist);
        scheduleRuleEntity.setIsStatusBase(scheduleRule.getStatusScheduleRule());
        scheduleRuleEntity.setStartWorkTime(scheduleRule.getDailyWorkSchedule().getStartWorkTime());
        scheduleRuleEntity.setEndWorkTime(scheduleRule.getDailyWorkSchedule().getEndWorkTime());
        scheduleRuleEntity.setCountDaySet(scheduleRule.getCountDaySet());
        scheduleRuleEntity.setRestInterval(scheduleRule.getDailyWorkSchedule().getRestInterval());
        scheduleRuleEntity.setBaseDurationAppointment(scheduleRule.getDailyWorkSchedule().getBaseDurationAppointment());
        scheduleRuleEntity.setStartLunchTime(scheduleRule.getDailyWorkSchedule().getStartLunchTime());
        scheduleRuleEntity.setEndLunchTime(scheduleRule.getDailyWorkSchedule().getEndLunchTime());
        scheduleRuleEntity.setWeekendDay(String.join(";", scheduleRule.getWeekendDay()));
        scheduleRuleEntity.setDayOfWeekSet(String.join(";", scheduleRule.getDayOfWeekSet()));
//        scheduleRuleEntity.setSpecialistServicesEntities(scheduleRule.availableServiceList()
//                .stream()
//                .map(this::convertToSpecialistServicesEntity)
//                .collect(Collectors.toList()));
//        scheduleRuleEntity.setCabinetEntityList(scheduleRule.ca()
//                .stream()
//                .map(this::convertToCabinetEntity)
//                .collect(Collectors.toList()));
    }

    public ScheduleRule mapToModel(ScheduleRuleEntity scheduleRule) {
        return new ScheduleRule(scheduleRule);
    }

    /*
        public AddScheduleRuleOutput toAddScheduleRuleOutput(ScheduleRuleEntity newScheduleRuleEntity) {
        return new AddScheduleRuleOutput(
                newScheduleRuleEntity.getId(),
                newScheduleRuleEntity.getIsStatusBase(),
                newScheduleRuleEntity.getStartWorkTime(),
                newScheduleRuleEntity.getEndWorkTime(),
                newScheduleRuleEntity.getRestInterval(),
                newScheduleRuleEntity.getBaseDurationAppointment(),
                newScheduleRuleEntity.getStartLunchTime(),
                newScheduleRuleEntity.getEndLunchTime(),
                newScheduleRuleEntity.getCountDaySet(),
                newScheduleRuleEntity.getWeekendDay().split(";"),
                newScheduleRuleEntity.getDayOfWeekSet().split(";"),

        );
    }
     */
}
