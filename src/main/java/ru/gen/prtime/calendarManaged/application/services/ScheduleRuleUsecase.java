package ru.gen.prtime.calendarManaged.application.services;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleDto;
import ru.gen.prtime.calendarManaged.application.apiport.ScheduleRuleService;
import ru.gen.prtime.calendarManaged.application.mapper.ScheduleRuleMapper;
import ru.gen.prtime.calendarManaged.api.exhandlers.exceptions.ResourceNotFoundException;
import ru.gen.prtime.calendarManaged.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.calendarManaged.infrastructure.repositories.ScheduleRuleEntityRepository;
import ru.gen.prtime.calendarManaged.infrastructure.adapters.UserAdapter;
import ru.gen.prtime.userAccessManagement.security.entities.User;

@Service
@RequiredArgsConstructor
public class ScheduleRuleUsecase implements ScheduleRuleService {

    private final UserAdapter userAdapter;
    private final ScheduleRuleEntityRepository scheduleRuleEntityRepository;
    private final ScheduleRuleMapper scheduleRuleMapper;

    @Override
    public AddScheduleRuleDto newScheduleRule(@Valid AddScheduleRuleDto scheduleRule) {
        User specialist = userAdapter.getUserById(scheduleRule.specialistId());
        ScheduleRuleEntity newScheduleRule = scheduleRuleEntityRepository.save(scheduleRuleMapper.mapToEntity(scheduleRule, specialist));
        return scheduleRuleMapper.mapToApi(scheduleRuleEntityRepository.save(newScheduleRule));
    }

    @Override
    public void deleteScheduleRule(Long idScheduleRule) {
        scheduleRuleEntityRepository.findById(idScheduleRule).ifPresentOrElse(scheduleRuleEntityRepository::delete, () -> {
            throw new ResourceNotFoundException("Категория не найдена!");
        });
    }
}