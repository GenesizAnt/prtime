package ru.gen.prtime.service;

import io.micrometer.observation.ObservationFilter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.repository.InMemoryReceptionRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceptionService {

    private final InMemoryReceptionRepository receptionRepository;
    private final ModelMapper modelMapper;
    public List<Reception> findAllReceptions() {
        return receptionRepository.findAll();
    }

    public void save(ReceptionDTO receptionDTO) {
        Reception reception = modelMapper.map(receptionDTO, Reception.class);
        receptionRepository.save(reception);
    }

    public Optional<Reception> findReception(String receptionId) {
        //ToDo возвращать оптионал
        return receptionRepository.findById(receptionId);
    }
}