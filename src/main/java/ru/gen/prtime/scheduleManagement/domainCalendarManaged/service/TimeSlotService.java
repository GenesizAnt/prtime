package ru.gen.prtime.scheduleManagement.domainCalendarManaged.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;
import ru.gen.prtime.scheduleManagement.infrastructure.repositories.TimeSlotRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public Optional<TimeSlot> getTimeSlotById(Long timeSlotId) {
        return timeSlotRepository.findById(timeSlotId);
    }
}
