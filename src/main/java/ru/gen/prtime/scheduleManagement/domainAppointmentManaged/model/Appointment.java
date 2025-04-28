package ru.gen.prtime.scheduleManagement.domainAppointmentManaged.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domainServiceManaged.model.SpecialistServiceModel;
import ru.gen.prtime.scheduleManagement.shared.valueobjects.DateTimeParameters;
import ru.gen.prtime.calendarManaged.infrastructure.entities.TimeSlot;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {

    private Long timeSlotId;
    private DateTimeParameters dateTimeParameters;
    private StatusAppointment statusAppointment;
    private Boolean statusRegistrationClient;
    private LocalDateTime lockedAt;
    private Long clientId;
    private Long specialistId;
//    private Cabinet cabinet;
    private SpecialistServiceModel specialistService;
    private Boolean isPrimaryVisit;

    public Appointment(TimeSlot timeSlot) {
        this.timeSlotId = timeSlot.getId();
        this.dateTimeParameters = new DateTimeParameters(timeSlot);
        this.statusAppointment = timeSlot.getStatusAppointment();
        this.statusRegistrationClient = timeSlot.getStatusRegistrationClient();
        this.lockedAt = timeSlot.getLockedAt();
        this.clientId = timeSlot.getClient().getId();
        this.specialistId = timeSlot.getSpecialist().getId();
//        this.cabinet = new Cabinet(timeSlot.getCabinet());
        this.specialistService = new SpecialistServiceModel(timeSlot.getSpecialistService());
        this.isPrimaryVisit = timeSlot.getIsPrimaryVisit();
    }
}
