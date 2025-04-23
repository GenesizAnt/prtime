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
import ru.gen.prtime.scheduleManagement.api.dto.schedule_rule.AddScheduleRuleResponse;
import ru.gen.prtime.scheduleManagement.api.mapper.ScheduleRuleMapperApi;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleInput;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleOutput;
import ru.gen.prtime.scheduleManagement.application.usecase.ScheduleRuleUsecase;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/schedule-rule")
public class ScheduleRuleController {

    private final ScheduleRuleUsecase scheduleRuleUsecase;
    private final ScheduleRuleMapperApi scheduleRuleMapperApi;
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
            AddScheduleRuleResponse newScheduleRule = scheduleRuleUsecase.createNewScheduleRule(addScheduleRuleRequest);
            return ResponseEntity.ok(
                    new ApiResponse(
                            "Добавлен новый шаблон расписания",
                            scheduleRuleMapperApi.toAddScheduleRuleResponse(newScheduleRule)));
        }
    }
}
