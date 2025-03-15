package ru.gen.prtime.clientAppContext.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.model.Appointment;
import ru.gen.prtime.scheduleManagement.domain.model.Specialist;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.PersonFullName;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    private Long userId;
    private PersonFullName personFullName;
    private Boolean statusRegistration;
    private List<Appointment> futureAppointments;
    private List<Appointment> patsAppointments;
    private List<Appointment> allAppointments;
    private Specialist specialist;
}
