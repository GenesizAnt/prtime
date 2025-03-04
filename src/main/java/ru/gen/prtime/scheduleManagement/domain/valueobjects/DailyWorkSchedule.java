package ru.gen.prtime.scheduleManagement.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DailyWorkSchedule {

    private LocalTime startWorkTime;
    private LocalTime endWorkTime;
    private Duration restInterval;
    private Duration baseDurationAppointment;
    private LocalTime startLunchTime;
    private LocalTime endLunchTime;
    private Duration lunchDuration;
}