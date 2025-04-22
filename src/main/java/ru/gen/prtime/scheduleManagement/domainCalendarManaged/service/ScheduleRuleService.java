package ru.gen.prtime.scheduleManagement.domainCalendarManaged.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleInput;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleOutput;
import ru.gen.prtime.scheduleManagement.infrastructure.adapters.SpecialistServicesAdapter;
import ru.gen.prtime.scheduleManagement.infrastructure.adapters.UserAdapter;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.CabinetEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.mapper.ScheduleRuleEntityMapper;
import ru.gen.prtime.scheduleManagement.infrastructure.repositories.CabinetEntityRepository;
import ru.gen.prtime.scheduleManagement.infrastructure.repositories.ScheduleRuleEntityRepository;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.SpecialistServicesEntity;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleRuleService {

    private final ScheduleRuleEntityRepository scheduleRuleEntityRepository;
    private final CabinetEntityRepository cabinetEntityRepository;
    private final UserAdapter userAdapter;
    private final SpecialistServicesAdapter specialistServicesAdapter;
    private final ScheduleRuleEntityMapper scheduleRuleEntityMapper;

    @Transactional
    public AddScheduleRuleOutput createNewScheduleRule(AddScheduleRuleInput scheduleRule) {
        ScheduleRuleEntity scheduleRuleEntity = new ScheduleRuleEntity();
        scheduleRuleEntity.setSpecialist(userAdapter.getUserById(scheduleRule.specialistId()));
        scheduleRuleEntity.setIsStatusBase(scheduleRule.isStatusBase());
        scheduleRuleEntity.setStartWorkTime(scheduleRule.startWorkTime());
        scheduleRuleEntity.setEndWorkTime(scheduleRule.endWorkTime());
        scheduleRuleEntity.setCountDaySet(scheduleRule.countDaySet());
        scheduleRuleEntity.setRestInterval(scheduleRule.restInterval());
        scheduleRuleEntity.setBaseDurationAppointment(scheduleRule.baseDurationAppointment());
        scheduleRuleEntity.setStartLunchTime(scheduleRule.startLunchTime());
        scheduleRuleEntity.setEndLunchTime(scheduleRule.endLunchTime());
        scheduleRuleEntity.setWeekendDay(String.join(";", scheduleRule.weekendDay()));
        scheduleRuleEntity.setDayOfWeekSet(String.join(";", scheduleRule.dayOfWeekSet()));
        scheduleRuleEntity.setSpecialistServicesEntities(scheduleRule.availableServiceList()
                .stream()
                .map(this::convertToSpecialistServicesEntity)
                .collect(Collectors.toList()));
        scheduleRuleEntity.setCabinetEntityList(scheduleRule.cabinetList()
                .stream()
                .map(this::convertToCabinetEntity)
                .collect(Collectors.toList()));
        return scheduleRuleEntityMapper.toAddScheduleRuleOutput(scheduleRuleEntityRepository.save(scheduleRuleEntity));
    }


    private CabinetEntity convertToCabinetEntity(Long cabinetId) {
        return cabinetEntityRepository.getCabinetEntitiesById(cabinetId);
    }

    private SpecialistServicesEntity convertToSpecialistServicesEntity(Long specialistServiceId) {
        return specialistServicesAdapter.getSpecialistServiceById(specialistServiceId);
    }
}
