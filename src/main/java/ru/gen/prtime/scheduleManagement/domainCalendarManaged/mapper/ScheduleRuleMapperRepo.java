package ru.gen.prtime.scheduleManagement.domainCalendarManaged.mapper;

import org.springframework.stereotype.Component;
import ru.gen.prtime.scheduleManagement.domainCalendarManaged.model.ScheduleRule;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;

import java.util.stream.Collectors;

@Component
public class ScheduleRuleMapperRepo {

    public ScheduleRuleEntity mapToORM(ScheduleRule scheduleRule) {
        ScheduleRuleEntity scheduleRuleEntity = new ScheduleRuleEntity();
        scheduleRuleEntity.setSpecialist(userAdapter.getUserById(scheduleRule.getSpecialistId()));
        scheduleRuleEntity.setIsStatusBase(scheduleRule.isStatusBase());
        scheduleRuleEntity.setStartWorkTime(scheduleRule.startWorkTime());
        scheduleRuleEntity.setEndWorkTime(scheduleRule.endWorkTime());
        scheduleRuleEntity.setCountDaySet(scheduleRule.countDaySet());
        scheduleRuleEntity.setRestInterval(scheduleRule.restInterval());
        scheduleRuleEntity.setBaseDurationAppointment(scheduleRule.baseDurationAppointment());
        scheduleRuleEntity.setStartLunchTime(scheduleRule.startLunchTime());
        scheduleRuleEntity.setEndLunchTime(scheduleRule.endLunchTime());
        scheduleRuleEntity.setWeekendDay(String.join(";", scheduleRule.weekendDay()));
        scheduleRuleEntity.setDayOfWeekSet(String.join(";", scheduleRule.dayOfWeekSet()));
        scheduleRuleEntity.setSpecialistServicesEntities(scheduleRule.availableServiceList()
                .stream()
                .map(this::convertToSpecialistServicesEntity)
                .collect(Collectors.toList()));
        scheduleRuleEntity.setCabinetEntityList(scheduleRule.cabinetList()
                .stream()
                .map(this::convertToCabinetEntity)
                .collect(Collectors.toList()));
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
