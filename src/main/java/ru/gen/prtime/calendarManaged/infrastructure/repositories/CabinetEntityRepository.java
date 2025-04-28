package ru.gen.prtime.calendarManaged.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.calendarManaged.infrastructure.entities.CabinetEntity;

public interface CabinetEntityRepository extends JpaRepository<CabinetEntity, Long> {
    CabinetEntity getCabinetEntitiesById(Long id);
}
