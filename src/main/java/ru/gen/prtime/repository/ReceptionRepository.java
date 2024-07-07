package ru.gen.prtime.repository;

import ru.gen.prtime.entity.Reception;

import java.util.List;

public interface ReceptionRepository {
    List<Reception> findAll();
}
