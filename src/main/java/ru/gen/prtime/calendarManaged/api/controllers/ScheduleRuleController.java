package ru.gen.prtime.calendarManaged.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleDto;
import ru.gen.prtime.calendarManaged.application.services.ScheduleRuleUsecase;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/schedule-rule")
public class ScheduleRuleController {

    private final ScheduleRuleUsecase scheduleRuleUsecase;

    @PostMapping("/create")
    public ResponseEntity<AddScheduleRuleDto> createNewScheduleRule(@Valid @RequestBody AddScheduleRuleDto addScheduleRuleDto) {
        AddScheduleRuleDto newScheduleRule = scheduleRuleUsecase.newScheduleRule(addScheduleRuleDto);
        return ResponseEntity.ok(newScheduleRule);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> removeScheduleRule(@RequestBody Long idScheduleRule) {
        scheduleRuleUsecase.deleteScheduleRule(idScheduleRule);
        return ResponseEntity.ok(null);
    }

    @PatchMapping
}

/*
@RestController
@RequestMapping("/api/schedule-rules")
@RequiredArgsConstructor
public class ScheduleRuleController {

    private final ScheduleRuleService scheduleRuleService;

    @PatchMapping("/{id}")
    @Operation(summary = "Частичное обновление правил расписания")
    public ResponseEntity<ScheduleRule> updateScheduleRule(
            @PathVariable Long id,
            @RequestBody ScheduleRuleUpdateDto updateDto) {

        ScheduleRule updatedRule = scheduleRuleService.partialUpdate(id, updateDto);
        return ResponseEntity.ok(updatedRule);
    }
}
 */

/*
@Service
@RequiredArgsConstructor
public class ScheduleRuleService {

    private final ScheduleRuleRepository scheduleRuleRepository;

    @Transactional
    public ScheduleRule partialUpdate(Long id, ScheduleRuleUpdateDto updateDto) {
        ScheduleRule existingRule = scheduleRuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ScheduleRule not found with id: " + id));

        updateIfNotNull(updateDto.getStartWorkTime(), existingRule::setStartWorkTime);
        updateIfNotNull(updateDto.getEndWorkTime(), existingRule::setEndWorkTime);
        updateIfNotNull(updateDto.getRestInterval(), existingRule::setRestInterval);
        updateIfNotNull(updateDto.getBaseDurationAppointment(), existingRule::setBaseDurationAppointment);
        updateIfNotNull(updateDto.getStartLunchTime(), existingRule::setStartLunchTime);
        updateIfNotNull(updateDto.getEndLunchTime(), existingRule::setEndLunchTime);

        return scheduleRuleRepository.save(existingRule);
    }

    private <T> void updateIfNotNull(T newValue, Consumer<T> setter) {
        if (newValue != null) {
            setter.accept(newValue);
        }
    }
}
 */