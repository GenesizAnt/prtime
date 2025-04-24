package ru.gen.prtime.scheduleManagement.infrastructure.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gen.prtime.scheduleManagement.domainCalendarManaged.model.ScheduleRule;
import ru.gen.prtime.scheduleManagement.infrastructure.mapper.ScheduleRuleInfraMapper;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.repositories.ScheduleRuleEntityRepository;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleRuleService {

    private final ScheduleRuleEntityRepository scheduleRuleEntityRepository;
//    private final UserAdapter userAdapter;
//    private final SpecialistServicesAdapter specialistServicesAdapter;
//    private final ScheduleRuleEntityMapper scheduleRuleEntityMapper;
    private final ScheduleRuleInfraMapper scheduleRuleInfraMapper;

    @Transactional
    public ScheduleRule newScheduleRule(User specialist, ScheduleRule scheduleRule) {
        ScheduleRuleEntity scheduleRuleEntity = scheduleRuleInfraMapper.mapToORM(specialist, scheduleRule);
//        ScheduleRuleEntity scheduleRuleEntity = new ScheduleRuleEntity();
//        scheduleRuleEntity.setSpecialist();
//        scheduleRuleEntity.setIsStatusBase(scheduleRule.getStatusScheduleRule());
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
//                .map(this::cabinetEntity)
//                .collect(Collectors.toList()));
        return scheduleRuleInfraMapper.mapToModel(scheduleRuleEntityRepository.save(scheduleRuleEntity));
    }


//    private CabinetEntity cabinetEntity(Long cabinetId) {
//        return cabinetEntityRepository.getCabinetEntitiesById(cabinetId);
//    }

//    private SpecialistServicesEntity convertToSpecialistServicesEntity(Long specialistServiceId) {
//        return specialistServicesAdapter.getSpecialistServiceById(specialistServiceId);
//    }
}
