package ru.gen.prtime.calendarManaged.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.calendarManaged.infrastructure.entities.SpecialistServicesEntity;

public interface SpecialistServicesRepository extends JpaRepository<SpecialistServicesEntity, Long> {
    SpecialistServicesEntity getSpecialistServicesEntitiesById(Long id);
}
