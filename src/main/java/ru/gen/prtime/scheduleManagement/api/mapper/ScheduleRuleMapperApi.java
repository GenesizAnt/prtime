package ru.gen.prtime.scheduleManagement.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.gen.prtime.scheduleManagement.api.dto.schedule_rule.AddScheduleRuleRequest;
import ru.gen.prtime.scheduleManagement.api.dto.schedule_rule.AddScheduleRuleResponse;
import ru.gen.prtime.scheduleManagement.application.dto.AddScheduleRuleInput;

@Component
@RequiredArgsConstructor
public class ScheduleRuleMapperApi {

    private final ModelMapper modelMapper;

    public AddScheduleRuleInput toInputEntity(AddScheduleRuleRequest addScheduleRuleRequest) {
//        AddScheduleRuleInput addScheduleRuleInput = modelMapper.map(addScheduleRuleRequest, AddScheduleRuleInput.class);
//        AddScheduleRuleInput scheduleRule = new AddScheduleRuleInput();
//        scheduleRule.setStatusScheduleRule(determineScheduleRule(addScheduleRuleRequest.isStatusBase()));
//        scheduleRule.setDailyWorkSchedule(new DailyWorkSchedule(
//                addScheduleRuleRequest.startWorkTime(),
//                addScheduleRuleRequest.endWorkTime(),
//                addScheduleRuleRequest.restInterval(),
//                addScheduleRuleRequest.baseDurationAppointment(),
//                addScheduleRuleRequest.startLunchTime(),
//                addScheduleRuleRequest.endLunchTime()));
//        scheduleRule.setCountDaySet(addScheduleRuleRequest.countDaySet());
//        scheduleRule.setWeekendDay(addScheduleRuleRequest.weekendDay());
//        scheduleRule.setDayOfWeekSet(addScheduleRuleRequest.dayOfWeekSet());
//        scheduleRule.setAvailableServiceList(addScheduleRuleRequest.availableServiceList());
        return modelMapper.map(addScheduleRuleRequest, AddScheduleRuleInput.class);
    }

    public Object toAddScheduleRuleResponse(AddScheduleRuleResponse newScheduleRule) {
        return null;
    }

//    private SpecialistServiceModel convertToSpecialistService(SpecialistServiceModelDto serviceModelDto) {
//        SpecialistServiceModel serviceModel = new SpecialistServiceModel();
//        serviceModel.setId();
//        serviceModel.setServiceName();
//        serviceModel.setDescription();
//        serviceModel.setShortDescription();
//        serviceModel.setPrice();
//
//        private String serviceName;
//        private String description;
//        private String shortDescription;
//        private BigDecimal price;
////        return new SpecialistServiceModel(serviceModelDto.serviceId(), serviceModelDto.serviceName());
//    }

//    private ScheduleRuleDto.SpecialistServiceModel convertToDtoSpecialistService(SpecialistServiceModel serviceModel) {
//        return new ScheduleRuleDto.SpecialistServiceModel(serviceModel.getServiceId(), serviceModel.getServiceName());
//    }
}
