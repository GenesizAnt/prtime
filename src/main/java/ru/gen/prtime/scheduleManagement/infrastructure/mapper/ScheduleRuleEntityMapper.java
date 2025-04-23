package ru.gen.prtime.scheduleManagement.infrastructure.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;

@Component
@RequiredArgsConstructor
public class ScheduleRuleEntityMapper {


//    public AddScheduleRuleOutput toAddScheduleRuleOutput(ScheduleRuleEntity newScheduleRuleEntity) {
//        return new AddScheduleRuleOutput(
//                newScheduleRuleEntity.getId(),
//                newScheduleRuleEntity.getIsStatusBase(),
//                newScheduleRuleEntity.getStartWorkTime(),
//                newScheduleRuleEntity.getEndWorkTime(),
//                newScheduleRuleEntity.getRestInterval(),
//                newScheduleRuleEntity.getBaseDurationAppointment(),
//                newScheduleRuleEntity.getStartLunchTime(),
//                newScheduleRuleEntity.getEndLunchTime(),
//                newScheduleRuleEntity.getCountDaySet(),
//                newScheduleRuleEntity.getWeekendDay().split(";"),
//                newScheduleRuleEntity.getDayOfWeekSet().split(";"),
//
//        );
//    }
}
/*

        @NotNull
        @Size(min = 1)
        List<Long> availableServiceList,

        @NotNull
        @Size(min = 1)
        List<Long> cabinetList
 */