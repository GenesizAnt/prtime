package ru.gen.prtime.scheduleManagement.shared.valueobjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.calendarManaged.infrastructure.entities.TimeSlot;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class DateTimeParameters {
    private LocalDate dateSlot;
    private LocalTime startTimeSlot;
    private LocalTime endTimeSlot;
    private String dayOfWeek;

    public DateTimeParameters(TimeSlot timeSlot) {
        validateDateSlot(timeSlot.getDateSlot());
        validateTimeSlots(timeSlot.getStartTimeSlot(), timeSlot.getEndTimeSlot());
        validateDayOfWeek(timeSlot.getDayOfWeek());

        this.dateSlot = timeSlot.getDateSlot();
        this.startTimeSlot = timeSlot.getStartTimeSlot();
        this.endTimeSlot = timeSlot.getEndTimeSlot();
        this.dayOfWeek = timeSlot.getDayOfWeek();
    }

    private void validateDateSlot(LocalDate dateSlot) {
        Objects.requireNonNull(dateSlot, "Дата не может быть null.");
        if (dateSlot.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Дата не может быть в прошлом.");
        }
    }

    private void validateTimeSlots(LocalTime startTimeSlot, LocalTime endTimeSlot) {
        if (startTimeSlot == null || endTimeSlot == null) {
            throw new IllegalArgumentException("Время начала и окончания не могут быть null.");
        }
        if (startTimeSlot.isAfter(endTimeSlot)) {
            throw new IllegalArgumentException("Время начала не может быть позже времени окончания.");
        }
        if (startTimeSlot.equals(endTimeSlot)) {
            throw new IllegalArgumentException("Время начала и окончания не могут совпадать.");
        }
    }

    private void validateDayOfWeek(String dayOfWeek) {
        Objects.requireNonNull(dayOfWeek, "День недели не может быть null.");
    }
}
