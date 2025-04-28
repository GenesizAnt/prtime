package ru.gen.prtime.calendarManaged.application.apiport;

import jakarta.validation.Valid;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleDto;

public interface ScheduleRuleService {

    AddScheduleRuleDto newScheduleRule(AddScheduleRuleDto scheduleRuleRequest);

    void deleteScheduleRule(@Valid Long idScheduleRule);
}
