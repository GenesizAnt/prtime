package ru.gen.prtime.scheduleManagement.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.scheduleManagement.domain.model.ScheduleRule;
import ru.gen.prtime.scheduleManagement.infrastructure.repositories.ScheduleRuleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleRuleService {

    private final ScheduleRuleRepository scheduleRuleRepository;

    public ScheduleRule createNewScheduleRule(ScheduleRule scheduleRule) {
        return scheduleRuleRepository.save(scheduleRule);
    }
}
