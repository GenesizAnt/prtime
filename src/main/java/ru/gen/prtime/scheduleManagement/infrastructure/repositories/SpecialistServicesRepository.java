package ru.gen.prtime.scheduleManagement.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.SpecialistServicesEntity;

public interface SpecialistServicesRepository extends JpaRepository<SpecialistServicesEntity, Long> {
    SpecialistServicesEntity getSpecialistServicesEntitiesById(Long id);
}
