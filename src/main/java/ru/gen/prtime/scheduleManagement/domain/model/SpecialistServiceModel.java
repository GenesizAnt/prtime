package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpecialistServiceModel {

    private Long id;
    private String serviceName;
    private String description;
    private String shortDescription;
    private BigDecimal price;
}
