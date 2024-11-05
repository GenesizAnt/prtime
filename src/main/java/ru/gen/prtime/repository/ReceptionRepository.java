package ru.gen.prtime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gen.prtime.entity.Reception;

public interface ReceptionRepository extends JpaRepository<Reception, Integer> {

}
