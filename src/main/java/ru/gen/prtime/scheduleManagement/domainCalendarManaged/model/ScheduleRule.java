package ru.gen.prtime.scheduleManagement.domainCalendarManaged.model;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.api.dto.schedule_rule.AddScheduleRuleRequest;
import ru.gen.prtime.scheduleManagement.domainServiceManaged.model.SpecialistServiceModel;
import ru.gen.prtime.scheduleManagement.shared.valueobjects.DailyWorkSchedule;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.SpecialistServicesEntity;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleRule {

    private Long scheduleRuleId;
    private Long specialistId;
    private StatusScheduleRule statusScheduleRule;
    private DailyWorkSchedule dailyWorkSchedule;
    private Integer countDaySet;
    private List<String> weekendDay;
    private List<String> dayOfWeekSet;

    public ScheduleRule(ScheduleRuleEntity scheduleRuleEntity) {
        this.scheduleRuleId = scheduleRuleEntity.getId();
        this.specialistId = scheduleRuleEntity.getSpecialist().getId();
        this.statusScheduleRule = scheduleRuleEntity.getIsStatusBase() ? StatusScheduleRule.BASE : StatusScheduleRule.EXTRA;
        this.dailyWorkSchedule = new DailyWorkSchedule(scheduleRuleEntity);
        this.countDaySet = scheduleRuleEntity.getCountDaySet();
        this.weekendDay = List.of(scheduleRuleEntity.getDayOfWeekSet().split(";"));
        this.dayOfWeekSet = List.of(scheduleRuleEntity.getDayOfWeekSet().split(";"));
    }

    public ScheduleRule(@Valid AddScheduleRuleRequest scheduleRuleRequest) {
        this.specialistId = scheduleRuleRequest.specialistId();
        this.statusScheduleRule = scheduleRuleRequest.isStatusBase() ? StatusScheduleRule.BASE : StatusScheduleRule.EXTRA;
        this.dailyWorkSchedule = new DailyWorkSchedule(scheduleRuleRequest);
        this.countDaySet = scheduleRuleRequest.countDaySet();
        this.weekendDay = scheduleRuleRequest.weekendDay();
        this.dayOfWeekSet = scheduleRuleRequest.dayOfWeekSet();
    }

//    private SpecialistServiceModel convertToSpecialistService(SpecialistServicesEntity specialistServicesEntity) {
//        return new SpecialistServiceModel(specialistServicesEntity);
//    }
}
