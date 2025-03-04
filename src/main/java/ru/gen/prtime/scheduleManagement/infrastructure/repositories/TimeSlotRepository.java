package ru.gen.prtime.scheduleManagement.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}
