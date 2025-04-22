package ru.gen.prtime.scheduleManagement.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.scheduleManagement.domainAppointmentManaged.model.Specialist;
import ru.gen.prtime.scheduleManagement.infrastructure.adapters.UserAdapter;

@Service
@RequiredArgsConstructor
public class SpecialistModelUsecase {

    private final UserAdapter userAdapter;

    public Specialist getSpecialistById(Long userId) {
        return userAdapter.getSpecialistById(userId);
    }
}
