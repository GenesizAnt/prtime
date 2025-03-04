package ru.gen.prtime.scheduleManagement.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.model.Appointment;
import ru.gen.prtime.scheduleManagement.domain.model.OpenTimeWindow;
import ru.gen.prtime.scheduleManagement.domain.model.ScheduleRule;
import ru.gen.prtime.scheduleManagement.domain.model.Specialist;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Calendar {

    private Specialist specialist;
    private List<Appointment> appointments;
    private List<OpenTimeWindow> openTimeWindows;
    private List<TimeSlot> allTimeWindows;
    private List<ScheduleRule> scheduleRules;
}
