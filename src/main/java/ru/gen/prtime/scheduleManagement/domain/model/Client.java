package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.Email;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.PersonFullName;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.PhoneNumber;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    private Long userId;
    private PersonFullName personFullName;
    private Boolean statusRegistration;
    private Specialist specialist;

    public Client(Long userId, PersonFullName personFullName, Boolean statusRegistration) {
        this.userId = userId;
        this.personFullName = personFullName;
        this.statusRegistration = statusRegistration;
    }
}
