package ru.gen.prtime.calendarManaged.application.services;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.calendarManaged.application.portinterface.ScheduleRuleService;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleRequest;
import ru.gen.prtime.calendarManaged.api.dto.AddScheduleRuleResponse;
import ru.gen.prtime.calendarManaged.application.mapper.ScheduleRuleMapper;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.repositories.ScheduleRuleEntityRepository;
import ru.gen.prtime.scheduleManagement.infrastructure.adapters.UserAdapter;
import ru.gen.prtime.userAccessManagement.security.entities.User;

@Service
@RequiredArgsConstructor
public class ScheduleRuleUsecase implements ScheduleRuleService {

    private final ScheduleRuleEntityRepository scheduleRuleEntityRepository;
//    private final ModelMapper modelMapper;
    private final ScheduleRuleMapper scheduleRuleMapper;
//    private final ScheduleRuleEntityRepository scheduleRuleEntityRepository;
    private final UserAdapter userAdapter;
//    private final SpecialistServicesAdapter specialistServicesAdapter;
//    private final CabinetRepository cabinetRepository;

    @Override
    public AddScheduleRuleResponse newScheduleRule(@Valid AddScheduleRuleRequest scheduleRuleRequest) {
//        ScheduleRule newScheduleRule = new ScheduleRule(scheduleRuleRequest);
        User specialist = userAdapter.getUserById(scheduleRuleRequest.specialistId());
//        ScheduleRule saveScheduleRule = scheduleRuleServicesdcsdc.newScheduleRule(specialist, newScheduleRule);

        ScheduleRuleEntity newScheduleRule = scheduleRuleEntityRepository.save(scheduleRuleMapper.mapToEntity(scheduleRuleRequest, specialist));

        return scheduleRuleMapper.mapToApi(newScheduleRule);

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