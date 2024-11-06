package ru.gen.prtime.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gen.prtime.dto.ReceptionDTO;
import ru.gen.prtime.entity.Reception;
import ru.gen.prtime.repository.ReceptionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceptionService {

//    private final InMemoryReceptionRepository receptionRepository;
    private  final ReceptionRepository receptionRepository;
    private final ModelMapper modelMapper;

    public List<Reception> findAllReceptions(String filter) {
        if (filter != null && filter.isBlank()) {
            return receptionRepository.findAllByReceptionDateBefore(LocalDate.parse(filter));//добавлен как пример фильтра
        } else {
            return receptionRepository.findAll();
        }
    }

    @Transactional
    public Reception save(ReceptionDTO receptionDTO) {
        Reception reception = modelMapper.map(receptionDTO, Reception.class);
        return receptionRepository.save(reception);
    }

    public Optional<Reception> findReception(Integer receptionId) {
        return receptionRepository.findById(receptionId);
    }

    @Transactional
    public void editReception(Integer receptionId, ReceptionDTO editReception) {
        receptionRepository.findById(receptionId)
                .ifPresentOrElse(reception -> {
                    reception.setReceptionDate(editReception.getReceptionDate());
                    reception.setReceptionTime(editReception.getReceptionTime());
                    receptionRepository.save(reception);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Transactional
    public void deleteReception(Integer receptionId) {
        receptionRepository.deleteById(receptionId);
    }
}