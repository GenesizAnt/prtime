package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Calendar {

    //ToDo НУЖНА ЛИ ЭТА СУЩНОСТЬ??????

    private Specialist specialist;
    List<Appointment> appointments;
    List<OpenTimeWindow> openTimeWindows;
    private List<ScheduleRule> scheduleRules;
}
