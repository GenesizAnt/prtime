package ru.gen.prtime.calendarManaged.application.portinterface;

import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleRequest;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleResponse;

public interface ScheduleRuleService {

    AddScheduleRuleResponse newScheduleRule(AddScheduleRuleRequest scheduleRuleRequest);
}
