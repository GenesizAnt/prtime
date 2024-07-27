package ru.gen.prtime.repository;

import org.springframework.stereotype.Repository;
import ru.gen.prtime.entity.Reception;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryReceptionRepository {

    private List<Reception> receptions = Collections.synchronizedList(new LinkedList<>());

    public InMemoryReceptionRepository() {
        IntStream.range(1, 4).forEach(i -> this.receptions.add(new Reception(i, LocalDate.now(), LocalTime.now())));
    }

    public List<Reception> findAll() {
        return Collections.unmodifiableList(this.receptions);
    }

    public Reception save(Reception reception) {
        receptions.add(reception);
        return reception;
    }

    public Optional<Reception> findById(Integer receptionId) {
        return receptions.stream()
                .filter(reception -> Objects.equals(receptionId, reception.getId()))
                .findFirst();
    }

    public void remove(Integer receptionId) {
        receptions = receptions.stream()
                .filter(reception -> !Objects.equals(receptionId, reception.getId()))
                .collect(Collectors.toList());
    }
}
