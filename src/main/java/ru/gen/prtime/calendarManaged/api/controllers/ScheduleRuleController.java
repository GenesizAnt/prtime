package ru.gen.prtime.calendarManaged.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleRequest;
import ru.gen.prtime.scheduleManagement.api.dto.ApiResponse;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleResponse;
import ru.gen.prtime.calendarManaged.application.services.ScheduleRuleUsecase;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/schedule-rule")
public class ScheduleRuleController {

    private final ScheduleRuleUsecase scheduleRuleUsecase;
//    private final ScheduleRuleMapperApi scheduleRuleMapperApi;
//    private final ModelMapper modelMapper;

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
            AddScheduleRuleResponse newScheduleRule = scheduleRuleUsecase.newScheduleRule(addScheduleRuleRequest);
            return ResponseEntity.ok(new ApiResponse("Добавлен новый шаблон расписания", newScheduleRule));
        }
    }
}
