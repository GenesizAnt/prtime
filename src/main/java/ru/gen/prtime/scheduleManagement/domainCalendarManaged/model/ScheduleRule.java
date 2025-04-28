package ru.gen.prtime.scheduleManagement.domainCalendarManaged.model;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleDto;
import ru.gen.prtime.scheduleManagement.shared.valueobjects.DailyWorkSchedule;
import ru.gen.prtime.calendarManaged.infrastructure.entities.ScheduleRuleEntity;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleRule {

    //ToDo каждая модель должна состоять только из VO и содержать проверку на IllegalArgumentException
    private Long scheduleRuleId;
    private Long specialistId;
    private String ruleName;
    private Boolean statusScheduleRule;
    private DailyWorkSchedule dailyWorkSchedule;
    private Integer countDaySet;
    private List<String> weekendDay;
    private List<String> dayOfWeekSet;

    public ScheduleRule(ScheduleRuleEntity scheduleRuleEntity) {
        this.scheduleRuleId = scheduleRuleEntity.getId();
        this.specialistId = scheduleRuleEntity.getSpecialist().getId();
        this.ruleName = scheduleRuleEntity.getRuleName();
        this.statusScheduleRule = scheduleRuleEntity.getIsStatusBase();
        this.dailyWorkSchedule = new DailyWorkSchedule(scheduleRuleEntity);
        this.countDaySet = scheduleRuleEntity.getCountDaySet();
        this.weekendDay = List.of(scheduleRuleEntity.getDayOfWeekSet().split(";"));
        this.dayOfWeekSet = List.of(scheduleRuleEntity.getDayOfWeekSet().split(";"));
    }

    public ScheduleRule(@Valid AddScheduleRuleDto scheduleRuleRequest) {
        this.specialistId = scheduleRuleRequest.specialistId();
        this.statusScheduleRule = scheduleRuleRequest.isStatusBase();
        this.ruleName = scheduleRuleRequest.ruleName();
        this.dailyWorkSchedule = new DailyWorkSchedule(scheduleRuleRequest);
        this.countDaySet = scheduleRuleRequest.countDaySet();
        this.weekendDay = scheduleRuleRequest.weekendDay();
        this.dayOfWeekSet = scheduleRuleRequest.dayOfWeekSet();
    }

//    private SpecialistServiceModel convertToSpecialistService(SpecialistServicesEntity specialistServicesEntity) {
//        return new SpecialistServiceModel(specialistServicesEntity);
//    }
}
