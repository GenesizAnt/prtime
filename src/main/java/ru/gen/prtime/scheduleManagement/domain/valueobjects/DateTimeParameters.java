package ru.gen.prtime.scheduleManagement.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DateTimeParameters {
    private String dayOfWeek;
    private LocalDate dateSlot;
    private LocalTime startTimeSlot;
    private LocalTime endTimeSlot;
}
