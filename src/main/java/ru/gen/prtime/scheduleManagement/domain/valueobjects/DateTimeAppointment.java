package ru.gen.prtime.scheduleManagement.domain.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@Getter
@Setter
public class DateTimeAppointment {
    @Column(name = "date_slot")
    private LocalDate dateSlot;

    @Column(name = "time_slot")
    private LocalTime timeStartSlot;

    @Column(name = "day_week")
    private String dayOfWeek;
}
