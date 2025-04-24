package ru.gen.prtime.scheduleManagement.application.mapper;

import org.springframework.stereotype.Component;
import ru.gen.prtime.scheduleManagement.api.dto.schedulerule.AddScheduleRuleResponse;
import ru.gen.prtime.scheduleManagement.domainCalendarManaged.model.ScheduleRule;

@Component
public class ScheduleRuleMapperApp {
    public AddScheduleRuleResponse mapToApi(ScheduleRule saveScheduleRule) {
        return null;
    }
}
