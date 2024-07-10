package ru.gen.prtime.repository;

import org.springframework.stereotype.Repository;
import ru.gen.prtime.entity.Reception;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryReceptionRepository  {

    private final List<Reception> receptions = Collections.synchronizedList(new LinkedList<>());

    public InMemoryReceptionRepository() {
        IntStream.range(1,4)
                .forEach(i -> this.receptions.add(new Reception(i, 1, i + 1, LocalDate.now(), LocalTime.now())));
    }

    public List<Reception> findAll() {
        return Collections.unmodifiableList(this.receptions);
    }

    public void save(Reception reception) {
        receptions.add(reception);
    }
}
