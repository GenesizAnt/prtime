package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.Cabinet;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.DateTimeParameters;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {

    //ToDo добавить версионирование в контроллеры есть пример

    private Long id;
    private DateTimeParameters dateTimeParameters;
    private StatusAppointment statusAppointment;
    private Boolean statusRegistrationClient;
    private LocalDateTime lockedAt;
    private Client client;
    private Specialist specialist;
    private Cabinet cabinet;
}
