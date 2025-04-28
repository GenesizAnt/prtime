package ru.gen.prtime.calendarManaged.infrastructure.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gen.prtime.calendarManaged.infrastructure.entities.SpecialistServicesEntity;
import ru.gen.prtime.calendarManaged.infrastructure.repositories.SpecialistServicesRepository;

@Component
@RequiredArgsConstructor
public class SpecialistServicesAdapter {

    private final SpecialistServicesRepository specialistServicesRepository;

    public SpecialistServicesEntity getSpecialistServiceById(Long specialistServiceId) {
        return specialistServicesRepository.getSpecialistServicesEntitiesById(specialistServiceId);
    }
}
