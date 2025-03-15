package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.Email;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.PersonFullName;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.PhoneNumber;
import ru.gen.prtime.specialistAdministrationWork.infrastructure.entities.SpecialistClientRelation;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    private Long userId;
    private PersonFullName personFullName;
    private Email email;
    private PhoneNumber phoneNumber;
    private LocalDate birthday;
    private Boolean statusRegistration;

    public Client(SpecialistClientRelation specialistClientRelation) {

    }
}
