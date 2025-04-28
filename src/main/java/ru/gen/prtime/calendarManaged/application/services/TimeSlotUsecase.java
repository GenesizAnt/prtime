package ru.gen.prtime.calendarManaged.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.calendarManaged.infrastructure.entities.TimeSlot;
import ru.gen.prtime.calendarManaged.infrastructure.repositories.TimeSlotRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeSlotUsecase {

    private final TimeSlotRepository timeSlotRepository;

    public Optional<TimeSlot> getTimeSlotById(Long timeSlotId) {
        return timeSlotRepository.findById(timeSlotId);
    }
}
