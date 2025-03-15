package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.*;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.UnregisteredClient;
import ru.gen.prtime.specialistAdministrationWork.infrastructure.entities.SpecialistClientRelation;
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
    private Calendar calendar;
    private List<Client> clients;
    private List<UnregisteredClient> unregisteredClients;
    private List<SpecialistServiceModel> availableServiceList;
    private List<Cabinet> cabinets;
    private List<ScheduleRule> scheduleRules;

    public Specialist(User user) {
        this.userId = user.getId();
        this.fullName = new PersonFullName(user.getFirstname(), user.getSurname(), user.getPatronymic());
        this.calendar = new Calendar(user);
        this.clients = user.getClientRelationList().stream().map(this::convertToClient).collect(Collectors.toList());
        this.unregisteredClients = user.getUnregisteredClients();
    }

    private Client convertToClient(SpecialistClientRelation specialistClientRelation) {
        return new Client(specialistClientRelation);
    }
}
