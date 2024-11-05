package ru.gen.prtime.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.repository.ReceptionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceptionService {

//    private final InMemoryReceptionRepository receptionRepository;
    private  final ReceptionRepository receptionRepository;
    private final ModelMapper modelMapper;

    public List<Reception> findAllReceptions() {
        return receptionRepository.findAll();
    }

    public Reception save(ReceptionDTO receptionDTO) {
        Reception reception = modelMapper.map(receptionDTO, Reception.class);
        return receptionRepository.save(reception);
    }

    public Optional<Reception> findReception(Integer receptionId) {
        return receptionRepository.findById(receptionId);
    }

    public void editReception(Integer receptionId, ReceptionDTO editReception) {
        receptionRepository.findById(receptionId)
                .ifPresentOrElse(reception -> {
                    reception.setReceptionDate(editReception.getReceptionDate());
                    reception.setReceptionTime(editReception.getReceptionTime());
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    public void deleteReception(Integer receptionId) {
        receptionRepository.deleteById(receptionId);
    }
}