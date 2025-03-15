package ru.gen.prtime.scheduleManagement.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.scheduleManagement.domain.model.Appointment;
import ru.gen.prtime.scheduleManagement.domain.model.OpenTimeWindow;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;
import ru.gen.prtime.scheduleManagement.infrastructure.service.TimeSlotService;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TimeSlotManageService {

    private final TimeSlotService timeSlotService;

    public Appointment getAppointmentById(Long timeSlotId) {
        TimeSlot timeSlot = timeSlotService.getTimeSlotById(timeSlotId).orElseThrow(() -> new NoSuchElementException(
                String.format("Прием у специалиста с id: '%s' не найден", timeSlotId)
        ));
        return new Appointment(timeSlot);
    }

    public OpenTimeWindow getOpenTimeWindowById(Long timeSlotId) {
        TimeSlot timeSlot = timeSlotService.getTimeSlotById(timeSlotId).orElseThrow(() -> new NoSuchElementException(
                String.format("Свободное окно для записи у специалиста с id: '%s' не найдено", timeSlotId)
        ));
        return new OpenTimeWindow(timeSlot);
    }
}
