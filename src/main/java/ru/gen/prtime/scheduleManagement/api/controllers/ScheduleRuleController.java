package ru.gen.prtime.scheduleManagement.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.gen.prtime.scheduleManagement.api.dto.ApiResponse;
import ru.gen.prtime.scheduleManagement.api.dto.ScheduleRuleDto;
import ru.gen.prtime.scheduleManagement.api.mapper.ScheduleRuleMapper;
import ru.gen.prtime.scheduleManagement.application.service.ScheduleRuleService;
import ru.gen.prtime.scheduleManagement.domain.model.ScheduleRule;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/schedule-rule")
public class ScheduleRuleController {

    private final ScheduleRuleService scheduleRuleService;
    private final ScheduleRuleMapper scheduleRuleMapper;

    @PostMapping
    public ResponseEntity<?> createNewScheduleRule(@Valid @RequestBody ScheduleRuleDto scheduleRuleDto,
                                                         BindingResult bindingResult) throws BindException {

        if (scheduleRuleDto.scheduleRuleId() != null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Id должен быть null");
        }
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            ScheduleRule newScheduleRule = scheduleRuleService.createNewScheduleRule(scheduleRuleMapper.toEntity(scheduleRuleDto));
            return ResponseEntity.ok(new ApiResponse("Добавлен новый шаблон расписания", scheduleRuleMapper.toScheduleRuleDto(newScheduleRule)));
        }
    }
}
