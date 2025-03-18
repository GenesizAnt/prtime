package ru.gen.prtime.scheduleManagement.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.scheduleManagement.domain.model.ScheduleRule;

public interface ScheduleRuleRepository extends JpaRepository<ScheduleRule, Long> {
}
