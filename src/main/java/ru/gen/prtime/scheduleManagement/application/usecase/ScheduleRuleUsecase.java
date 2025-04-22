package ru.gen.prtime.scheduleManagement.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleInput;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleOutput;
import ru.gen.prtime.scheduleManagement.domainCalendarManaged.service.ScheduleRuleService;

@Service
@RequiredArgsConstructor
public class ScheduleRuleUsecase {

    private final ScheduleRuleService scheduleRuleService;
//    private final ScheduleRuleEntityRepository scheduleRuleEntityRepository;
//    private final UserAdapter userAdapter;
//    private final SpecialistServicesAdapter specialistServicesAdapter;
//    private final CabinetRepository cabinetRepository;

    public AddScheduleRuleOutput createNewScheduleRule(AddScheduleRuleInput scheduleRule) {
        return scheduleRuleService.createNewScheduleRule(scheduleRule);
//        ScheduleRuleEntity scheduleRuleEntity = new ScheduleRuleEntity();
//        scheduleRuleEntity.setSpecialist(userAdapter.getUserById(scheduleRule.specialistId()));
//        scheduleRuleEntity.setStatusScheduleRule(determineScheduleRule(scheduleRule.isStatusBase()));
//        scheduleRuleEntity.setStartWorkTime(scheduleRule.startWorkTime());
//        scheduleRuleEntity.setEndWorkTime(scheduleRule.endWorkTime());
//        scheduleRuleEntity.setCountDaySet(scheduleRule.countDaySet());
//        scheduleRuleEntity.setRestInterval(scheduleRule.restInterval());
//        scheduleRuleEntity.setBaseDurationAppointment(scheduleRule.baseDurationAppointment());
//        scheduleRuleEntity.setStartLunchTime(scheduleRule.startLunchTime());
//        scheduleRuleEntity.setEndLunchTime(scheduleRule.endLunchTime());
//        scheduleRuleEntity.setWeekendDay(String.join(";", scheduleRule.weekendDay()));
//        scheduleRuleEntity.setDayOfWeekSet(String.join(";", scheduleRule.dayOfWeekSet()));
//        scheduleRuleEntity.setSpecialistServicesEntities(scheduleRule.availableServiceList()
//                .stream()
//                .map(this::convertToSpecialistServicesEntity)
//                .collect(Collectors.toList()));
//        scheduleRuleEntity.setCabinetEntityList(scheduleRule.cabinetList()
//                .stream()
//                .map(this::convertToCabinetEntity)
//                .collect(Collectors.toList()));
//        return null;
    }

//    private CabinetEntity convertToCabinetEntity(Long cabinetId) {
//        return
//    }
//
//    private SpecialistServicesEntity convertToSpecialistServicesEntity(Long specialistServiceId) {
//        return specialistServicesAdapter.getSpecialistServiceById(specialistServiceId);
//    }
//
//    private StatusScheduleRule determineScheduleRule(Boolean isBase) {
//        return isBase ? BASE : EXTRA;
//    }
}