package ru.gen.prtime.scheduleManagement.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gen.prtime.scheduleManagement.api.dto.schedule_rule.AddScheduleRuleRequest;
import ru.gen.prtime.scheduleManagement.api.dto.ApiResponse;
import ru.gen.prtime.scheduleManagement.api.mapper.ScheduleRuleMapper;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleInput;
import ru.gen.prtime.scheduleManagement.application.service.ScheduleRuleService;
import ru.gen.prtime.scheduleManagement.domain.model.ScheduleRule;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/schedule-rule")
public class ScheduleRuleController {

    private final ScheduleRuleService scheduleRuleService;
    private final ScheduleRuleMapper scheduleRuleMapper;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> createNewScheduleRule(@Valid @RequestBody AddScheduleRuleRequest addScheduleRuleRequest,
                                                         BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else {
                throw new BindException(bindingResult);
            }
        } else {
            ScheduleRule newScheduleRule = scheduleRuleService.createNewScheduleRule(modelMapper.map(addScheduleRuleRequest, AddScheduleRuleInput.class));
            return ResponseEntity.ok(
                    new ApiResponse(
                            "Добавлен новый шаблон расписания",
                            scheduleRuleMapper.toAddScheduleRuleResponse(newScheduleRule)));
        }
    }
}
