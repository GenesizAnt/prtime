package ru.gen.prtime.scheduleManagement.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.model.Appointment;
import ru.gen.prtime.scheduleManagement.domain.model.OpenTimeWindow;
import ru.gen.prtime.scheduleManagement.domain.model.ScheduleRule;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;
import ru.gen.prtime.userAccessManagement.security.entities.User;

import java.util.List;
import java.util.stream.Collectors;

import static ru.gen.prtime.scheduleManagement.domain.model.StatusTimeSlot.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Calendar {

    //ToDo IDEA Отображение календаря как даты, а при нажатии на дату внизу отображать встречи окошки
    private List<Appointment> appointments;
    private List<OpenTimeWindow> openTimeWindows;
    private List<TimeSlot> allTimeWindows;
    private List<ScheduleRule> scheduleRules;

    public Calendar(User user) {
        this.allTimeWindows = user.getSpecialistTimeSlots();
        this.appointments = user.getSpecialistTimeSlots().stream()
                .filter(it -> it.getStatusTimeSlot().equals(APPOINTMENT))
                .map(this::convertToAppointment)
                .collect(Collectors.toList());
        this.openTimeWindows = user.getSpecialistTimeSlots().stream()
                .filter(it -> it.getStatusTimeSlot().equals(VACANT))
                .map(this::convertToOpenTimeWindow)
                .collect(Collectors.toList());
        this.scheduleRules = user.getScheduleRuleEntities().stream()
                .map(this::convertToScheduleRule)
                .collect(Collectors.toList());
    }

    private ScheduleRule convertToScheduleRule(ScheduleRuleEntity scheduleRuleEntity) {
        return new ScheduleRule(scheduleRuleEntity);
    }

    private OpenTimeWindow convertToOpenTimeWindow(TimeSlot timeSlot) {
        return new OpenTimeWindow(timeSlot);
    }

    private Appointment convertToAppointment(TimeSlot timeSlot) {
        return new Appointment(timeSlot);
    }
}
