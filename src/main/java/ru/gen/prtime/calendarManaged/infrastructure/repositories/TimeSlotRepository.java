package ru.gen.prtime.calendarManaged.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.calendarManaged.infrastructure.entities.TimeSlot;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}
