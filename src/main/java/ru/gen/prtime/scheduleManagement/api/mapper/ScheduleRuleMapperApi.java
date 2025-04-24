package ru.gen.prtime.scheduleManagement.api.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.gen.prtime.scheduleManagement.api.dto.schedulerule.AddScheduleRuleResponse;
import ru.gen.prtime.scheduleManagement.domainCalendarManaged.model.ScheduleRule;

@Component
@RequiredArgsConstructor
public class ScheduleRuleMapperApi {

    private final ModelMapper modelMapper;

    public static AddScheduleRuleResponse toScheduleRuleResponse(ScheduleRule scheduleRule) {
        return new AddScheduleRuleResponse(
                scheduleRule.getScheduleRuleId(),
                scheduleRule.getSpecialistId(),
                scheduleRule.getRuleName(),
                scheduleRule.getStatusScheduleRule(),
                scheduleRule.getDailyWorkSchedule(),
                scheduleRule.getCountDaySet(),
                scheduleRule.getWeekendDay(),
                scheduleRule.getDayOfWeekSet()
        );
    }

    public Object toScheduleRuleResponse(AddScheduleRuleResponse newScheduleRule) {
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
