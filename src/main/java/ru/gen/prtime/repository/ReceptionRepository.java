package ru.gen.prtime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.entity.Reception;

import java.time.LocalDate;
import java.util.List;

public interface ReceptionRepository extends JpaRepository<Reception, Integer> {

    List<Reception> findAllByReceptionDateBefore(LocalDate receptionDate);
}
