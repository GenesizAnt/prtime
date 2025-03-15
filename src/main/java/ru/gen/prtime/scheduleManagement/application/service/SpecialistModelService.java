package ru.gen.prtime.scheduleManagement.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.scheduleManagement.domain.model.Specialist;
import ru.gen.prtime.scheduleManagement.infrastructure.adapters.UserAdapter;

@Service
@RequiredArgsConstructor
public class SpecialistModelService {

    private final UserAdapter userAdapter;

    public Specialist getSpecialistById(Long userId) {
        return userAdapter.getSpecialistById(userId);
    }
}
