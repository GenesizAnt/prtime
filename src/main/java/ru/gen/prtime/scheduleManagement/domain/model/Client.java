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
import java.util.Objects;
import java.util.Optional;

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
        if (specialistClientRelation.getIsRegistered()) {
            this.userId = specialistClientRelation.getClient().getId();
            this.personFullName = new PersonFullName(specialistClientRelation.getClient().getFirstname(),
                    specialistClientRelation.getClient().getSurname(),
                    specialistClientRelation.getClient().getPatronymic());
            this.email = specialistClientRelation.getClient().getEmail() != null ? new Email(specialistClientRelation.getClient().getEmail()) : null;
            this.phoneNumber = specialistClientRelation.getClient().getPhoneNumber() != null ? new PhoneNumber(specialistClientRelation.getClient().getPhoneNumber()) : null;
            this.birthday = specialistClientRelation.getClient().getBirthday();
        } else {
            this.userId = specialistClientRelation.getUnregisteredClient().getId();
            this.personFullName = new PersonFullName(specialistClientRelation.getUnregisteredClient().getFirstname(),
                    specialistClientRelation.getUnregisteredClient().getSurname(),
                    specialistClientRelation.getUnregisteredClient().getPatronymic());
            this.email = specialistClientRelation.getUnregisteredClient().getEmail() != null ? new Email(specialistClientRelation.getUnregisteredClient().getEmail()) : null;
            this.phoneNumber = specialistClientRelation.getUnregisteredClient().getPhoneNumber() != null ? new PhoneNumber(specialistClientRelation.getUnregisteredClient().getPhoneNumber()) : null;
            this.birthday = specialistClientRelation.getUnregisteredClient().getBirthday();
        }
        this.statusRegistration = specialistClientRelation.getIsRegistered();
    }
}
