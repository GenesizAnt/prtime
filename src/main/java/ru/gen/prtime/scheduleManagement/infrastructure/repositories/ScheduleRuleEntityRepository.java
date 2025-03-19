package ru.gen.prtime.scheduleManagement.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;

public interface ScheduleRuleEntityRepository extends JpaRepository<ScheduleRuleEntity, Long> {
}
