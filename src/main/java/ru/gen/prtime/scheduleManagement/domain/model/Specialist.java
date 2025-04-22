package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.*;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.CabinetEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.specialistAdministrationWork.infrastructure.entities.SpecialistClientRelation;
import ru.gen.prtime.specialistServiceManagement.infrastructure.entities.SpecialistServicesEntity;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Specialist {

    private Long userId;
    private PersonFullName fullName;
    private CalendarSpecialist calendarSpecialist;
    private List<Client> clients;
    private List<SpecialistServiceModel> availableServiceList;
    private List<Cabinet> cabinets;
    private List<ScheduleRule> scheduleRules;

    public Specialist(User user) {
        this.userId = user.getId();
        this.fullName = new PersonFullName(user.getFirstname(), user.getSurname(), user.getPatronymic());
        this.calendarSpecialist = new CalendarSpecialist(user);
        this.clients = user.getClientRelationList().stream().map(this::convertToClient).collect(Collectors.toList());
        this.availableServiceList = user.getSpecialistServices().stream().map(this::convertToSpecialistServiceModel).collect(Collectors.toList());
        this.cabinets = user.getCabinets().stream().map(this::convertToCabinet).collect(Collectors.toList());
        this.scheduleRules = user.getScheduleRuleEntities().stream().map(this::convertToScheduleRule).collect(Collectors.toList());
    }

    private ScheduleRule convertToScheduleRule(ScheduleRuleEntity scheduleRuleEntity) {
        return new ScheduleRule(scheduleRuleEntity);
    }

    private Cabinet convertToCabinet(CabinetEntity cabinetEntity) {
        return new Cabinet(cabinetEntity);
    }

    private SpecialistServiceModel convertToSpecialistServiceModel(SpecialistServicesEntity specialistServicesEntity) {
        return new SpecialistServiceModel(specialistServicesEntity);
    }

    private Client convertToClient(SpecialistClientRelation specialistClientRelation) {
        return new Client(specialistClientRelation);
    }
}
