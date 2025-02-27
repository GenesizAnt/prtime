package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.Lunch;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleRule {
    private Long id;
    private StatusScheduleRule statusScheduleRule;
    private LocalTime startWorkTime;
    private LocalTime endWorkTime;
    private Integer countDaySet;
    private Duration restInterval;
    private Duration baseDurationAppointment;
    private Lunch lunch;
    private List<String> weekendDay;
    private String dayOfWeekSet;
}
