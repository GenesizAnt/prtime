package ru.gen.prtime.scheduleManagement.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.model.Appointment;
import ru.gen.prtime.scheduleManagement.domain.model.OpenTimeWindow;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.util.List;
import java.util.stream.Collectors;

import static ru.gen.prtime.scheduleManagement.domain.model.StatusTimeSlot.APPOINTMENT;
import static ru.gen.prtime.scheduleManagement.domain.model.StatusTimeSlot.VACANT;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalendarSpecialist {

    //ToDo IDEA Отображение календаря как даты, а при нажатии на дату внизу отображать встречи окошки
    private Long specialistId;
    private List<Appointment> appointments; // Может это просто ТаймСлот?
    private List<OpenTimeWindow> openTimeWindows;
    private List<TimeSlot> allTimeWindows;

    public CalendarSpecialist(User user) {
        this.specialistId = user.getId();
        this.allTimeWindows = user.getSpecialistTimeSlots();
        this.appointments = user.getSpecialistTimeSlots().stream()
                .filter(it -> it.getStatusTimeSlot().equals(APPOINTMENT))
                .map(this::convertToAppointment)
                .collect(Collectors.toList());
        this.openTimeWindows = user.getSpecialistTimeSlots().stream()
                .filter(it -> it.getStatusTimeSlot().equals(VACANT))
                .map(this::convertToOpenTimeWindow)
                .collect(Collectors.toList());
    }

    private OpenTimeWindow convertToOpenTimeWindow(TimeSlot timeSlot) {
        return new OpenTimeWindow(timeSlot);
    }

    private Appointment convertToAppointment(TimeSlot timeSlot) {
        return new Appointment(timeSlot);
    }
}
