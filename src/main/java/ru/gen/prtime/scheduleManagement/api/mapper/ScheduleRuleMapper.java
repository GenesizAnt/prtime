package ru.gen.prtime.scheduleManagement.api.mapper;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import ru.gen.prtime.scheduleManagement.api.dto.ScheduleRuleDto;
import ru.gen.prtime.scheduleManagement.api.dto.SpecialistServiceModelDto;
import ru.gen.prtime.scheduleManagement.domain.model.ScheduleRule;
import ru.gen.prtime.scheduleManagement.domain.model.SpecialistServiceModel;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.DailyWorkSchedule;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Component
public class ScheduleRuleMapper {

    public ScheduleRule toEntity(ScheduleRuleDto scheduleRuleDto) {
        ScheduleRule scheduleRule = new ScheduleRule();
        scheduleRule.setStatusScheduleRule(scheduleRuleDto.statusScheduleRule());
        scheduleRule.setDailyWorkSchedule(new DailyWorkSchedule(
                scheduleRuleDto.startWorkTime(),
                scheduleRuleDto.endWorkTime(),
                scheduleRuleDto.restInterval(),
                scheduleRuleDto.baseDurationAppointment(),
                scheduleRuleDto.startLunchTime(),
                scheduleRuleDto.endLunchTime(),
                scheduleRuleDto.lunchDuration()));
        scheduleRule.setCountDaySet(scheduleRuleDto.countDaySet());
        scheduleRule.setWeekendDay(scheduleRuleDto.weekendDay());
        scheduleRule.setDayOfWeekSet(scheduleRuleDto.dayOfWeekSet());
        scheduleRule.setAvailableServiceList(scheduleRuleDto.availableServiceList().stream()
                .map(this::convertToSpecialistService)
                .collect(Collectors.toList()));
        return scheduleRule;
    }

    public ScheduleRuleDto toScheduleRuleDto(ScheduleRule scheduleRule) {
        return new ScheduleRuleDto(
                scheduleRule.getScheduleRuleId(),
                scheduleRule.getStatusScheduleRule(),
                scheduleRule.getDailyWorkSchedule().getStartWorkTime(),
                scheduleRule.getDailyWorkSchedule().getEndWorkTime(),
                scheduleRule.getDailyWorkSchedule().getRestInterval(),
                scheduleRule.getDailyWorkSchedule().getBaseDurationAppointment(),
                scheduleRule.getDailyWorkSchedule().getStartLunchTime(),
                scheduleRule.getDailyWorkSchedule().getEndLunchTime(),
                scheduleRule.getDailyWorkSchedule().getLunchDuration(),
                scheduleRule.getCountDaySet(),
                scheduleRule.getWeekendDay(),
                scheduleRule.getDayOfWeekSet(),
                availableServiceList
        );
    }

    private SpecialistServiceModel convertToSpecialistService(SpecialistServiceModelDto serviceModelDto) {
        SpecialistServiceModel serviceModel = new SpecialistServiceModel();
        serviceModel.setId();
        serviceModel.setServiceName();
        serviceModel.setDescription();
        serviceModel.setShortDescription();
        serviceModel.setPrice();

        private String serviceName;
        private String description;
        private String shortDescription;
        private BigDecimal price;
//        return new SpecialistServiceModel(serviceModelDto.serviceId(), serviceModelDto.serviceName());
    }

    private ScheduleRuleDto.SpecialistServiceModel convertToDtoSpecialistService(SpecialistServiceModel serviceModel) {
        return new ScheduleRuleDto.SpecialistServiceModel(serviceModel.getServiceId(), serviceModel.getServiceName());
    }
}
