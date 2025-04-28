package ru.gen.prtime.calendarManaged.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.calendarManaged.infrastructure.entities.ScheduleRuleEntity;

public interface ScheduleRuleEntityRepository extends JpaRepository<ScheduleRuleEntity, Long> {
    ScheduleRuleEntity id(Long id);
}
