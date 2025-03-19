package ru.gen.prtime.specialistServiceManagement.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.TimeSlot;
import ru.gen.prtime.specialistServiceManagement.infrastructure.entities.SpecialistServicesEntity;

public interface SpecialistServicesRepository extends JpaRepository<SpecialistServicesEntity, Long> {
    SpecialistServicesEntity getSpecialistServicesEntitiesById(Long id);
}
