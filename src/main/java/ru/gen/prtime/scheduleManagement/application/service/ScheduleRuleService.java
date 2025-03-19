package ru.gen.prtime.scheduleManagement.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleInput;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleOutput;
import ru.gen.prtime.scheduleManagement.domain.model.StatusScheduleRule;
import ru.gen.prtime.scheduleManagement.infrastructure.adapters.SpecialistServicesAdapter;
import ru.gen.prtime.scheduleManagement.infrastructure.adapters.UserAdapter;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.CabinetEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.repositories.ScheduleRuleEntityRepository;
import ru.gen.prtime.scheduleManagement.infrastructure.service.ScheduleRuleEntityService;
import ru.gen.prtime.specialistServiceManagement.infrastructure.entities.SpecialistServicesEntity;

import java.util.stream.Collectors;

import static ru.gen.prtime.scheduleManagement.domain.model.StatusScheduleRule.BASE;
import static ru.gen.prtime.scheduleManagement.domain.model.StatusScheduleRule.EXTRA;

@Service
@RequiredArgsConstructor
public class ScheduleRuleService {

    private final ScheduleRuleEntityService scheduleRuleEntityService;
//    private final ScheduleRuleEntityRepository scheduleRuleEntityRepository;
//    private final UserAdapter userAdapter;
//    private final SpecialistServicesAdapter specialistServicesAdapter;
//    private final CabinetRepository cabinetRepository;

    public AddScheduleRuleOutput createNewScheduleRule(AddScheduleRuleInput scheduleRule) {
        return scheduleRuleEntityService.createNewScheduleRule(scheduleRule);
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