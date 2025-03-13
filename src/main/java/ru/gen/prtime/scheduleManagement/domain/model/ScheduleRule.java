package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.DailyWorkSchedule;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleRule {

    private Long scheduleRuleId;
    private StatusScheduleRule statusScheduleRule;
    private DailyWorkSchedule dailyWorkSchedule;
    private Integer countDaySet;
    private List<String> weekendDay;
    private List<String> dayOfWeekSet;
    private Cabinet cabinet;
    private List<SpecialistServiceModel> availableServiceList;

    public ScheduleRule(ScheduleRuleEntity scheduleRuleEntity) {
        this.scheduleRuleId = scheduleRuleEntity.getId();
        this.statusScheduleRule = scheduleRuleEntity.getStatusScheduleRule();

    }
}
