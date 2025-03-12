package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Calendar {

    //ToDo IDEA Отображение календаря как даты, а при нажатии на дату внизу отображать встречи окошки
    private Specialist specialist;
    private List<Appointment> appointments;
    private List<OpenTimeWindow> openTimeWindows;
    private List<TimeSlot> allTimeWindows;
    private List<ScheduleRule> scheduleRules;
}
