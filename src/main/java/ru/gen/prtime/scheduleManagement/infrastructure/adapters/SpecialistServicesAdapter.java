package ru.gen.prtime.scheduleManagement.infrastructure.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gen.prtime.specialistServiceManagement.infrastructure.entities.SpecialistServicesEntity;
import ru.gen.prtime.specialistServiceManagement.infrastructure.repositories.SpecialistServicesRepository;

@Component
@RequiredArgsConstructor
public class SpecialistServicesAdapter {

    private final SpecialistServicesRepository specialistServicesRepository;

    public SpecialistServicesEntity getSpecialistServiceById(Long specialistServiceId) {
        return specialistServicesRepository.getSpecialistServicesEntitiesById(specialistServiceId);
    }
}
