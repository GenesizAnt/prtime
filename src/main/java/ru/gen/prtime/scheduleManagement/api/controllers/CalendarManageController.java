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
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.scheduleManagement.api.dto.ScheduleRuleDto;
import ru.gen.prtime.scheduleManagement.api.mapper.ScheduleRuleMapper;
import ru.gen.prtime.scheduleManagement.application.service.TimeSlotManageService;
import ru.gen.prtime.scheduleManagement.domain.model.ScheduleRule;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/calendar")
public class CalendarManageController {

    private final TimeSlotManageService timeSlotManageService;


//    @PostMapping
//    public ResponseEntity<?> createNewScheduleSpecialist(@Valid @RequestBody ScheduleRuleDto scheduleRuleDto,
//                                             BindingResult bindingResult) throws BindException {
//        if (bindingResult.hasErrors()) {
//            if (bindingResult instanceof BindException exception) {
//                throw exception;
//            } else {
//                throw new BindException(bindingResult);
//            }
//        } else {
//            ScheduleRule newScheduleRule = timeSlotManageService.createNewTimeSlotScheduleSpecialist(modelMapper.map(scheduleRuleDto, ScheduleRule.class));
////            Reception reception = receptionService.save(scheduleRuleDto);
//            return ResponseEntity.ok("");
//        }
//    }
}
