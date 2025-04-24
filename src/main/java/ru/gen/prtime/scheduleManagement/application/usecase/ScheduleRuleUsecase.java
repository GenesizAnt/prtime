package ru.gen.prtime.scheduleManagement.application.usecase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.scheduleManagement.api.dto.schedulerule.AddScheduleRuleRequest;
import ru.gen.prtime.scheduleManagement.api.dto.schedulerule.AddScheduleRuleResponse;
import ru.gen.prtime.scheduleManagement.application.mapper.ScheduleRuleMapperApp;
import ru.gen.prtime.scheduleManagement.domainCalendarManaged.model.ScheduleRule;
import ru.gen.prtime.scheduleManagement.infrastructure.service.ScheduleRuleService;
import ru.gen.prtime.scheduleManagement.infrastructure.adapters.UserAdapter;
import ru.gen.prtime.userAccessManagement.security.entities.User;

@Service
@RequiredArgsConstructor
public class ScheduleRuleUsecase {

    private final ScheduleRuleService scheduleRuleService;
//    private final ModelMapper modelMapper;
    private final ScheduleRuleMapperApp scheduleRuleMapperApp;
//    private final ScheduleRuleEntityRepository scheduleRuleEntityRepository;
    private final UserAdapter userAdapter;
//    private final SpecialistServicesAdapter specialistServicesAdapter;
//    private final CabinetRepository cabinetRepository;

    public AddScheduleRuleResponse newScheduleRule(@Valid AddScheduleRuleRequest scheduleRuleRequest) {
        ScheduleRule newScheduleRule = new ScheduleRule(scheduleRuleRequest);
        User specialist = userAdapter.getUserById(newScheduleRule.getSpecialistId());
        ScheduleRule saveScheduleRule = scheduleRuleService.newScheduleRule(specialist, newScheduleRule);
        return scheduleRuleMapperApp.mapToApi(saveScheduleRule);

//        ScheduleRule newScheduleRule = new ScheduleRule(scheduleRuleRequest);
//        ScheduleRule saveScheduleRule = scheduleRuleService.createNewScheduleRule(newScheduleRule);
//        return scheduleRuleMapperApp.mapToApi(saveScheduleRule);


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