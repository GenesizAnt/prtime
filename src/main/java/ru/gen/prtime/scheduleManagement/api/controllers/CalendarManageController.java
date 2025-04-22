package ru.gen.prtime.scheduleManagement.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gen.prtime.scheduleManagement.application.usecase.TimeSlotManageUsecase;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/calendar")
public class CalendarManageController {

    private final TimeSlotManageUsecase timeSlotManageUsecase;


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
