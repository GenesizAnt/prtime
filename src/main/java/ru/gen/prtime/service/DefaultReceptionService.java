package ru.gen.prtime.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.repository.ReceptionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultReceptionService implements ReceptionService {

    private final ReceptionRepository receptionRepository;

    @Override
    public List<Reception> findAllReceptions() {
        return receptionRepository.findAll();
    }
}
