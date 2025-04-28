package ru.gen.prtime.scheduleManagement.domainServiceManaged.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.calendarManaged.infrastructure.entities.SpecialistServicesEntity;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpecialistServiceModel {

    private Long specialistServiceId;
    private String serviceName;
    private String description;
    private String shortDescription;
    private BigDecimal price;

    public SpecialistServiceModel(SpecialistServicesEntity specialistService) {
        validateServiceName(specialistService.getServiceName());
        validateDescription(specialistService.getDescription());
        validateShortDescription(specialistService.getShortDescription());
        validatePrice(specialistService.getPrice());

        this.specialistServiceId = specialistService.getId();
        this.serviceName = specialistService.getServiceName();
        this.description = specialistService.getDescription();
        this.shortDescription = specialistService.getShortDescription();
        this.price = specialistService.getPrice();
    }

    private void validateServiceName(String serviceName) {
        if (serviceName == null || serviceName.trim().isEmpty()) {
            throw new IllegalArgumentException("Название услуги не может быть null или пустым.");
        }
        if (serviceName.length() > 100) {
            throw new IllegalArgumentException("Название услуги не должно превышать 100 символов.");
        }
    }

    private void validateDescription(String description) {
        if (description != null && description.length() > 1000) {
            throw new IllegalArgumentException("Подробное описание услуги не должно превышать 1000 символов.");
        }
    }

    private void validateShortDescription(String shortDescription) {
        if (shortDescription != null && shortDescription.length() > 255) {
            throw new IllegalArgumentException("Краткое описание услуги не должно превышать 255 символов.");
        }
    }

    private void validatePrice(BigDecimal price) {
        if (price == null) {
            throw new IllegalArgumentException("Стоимость услуги не может быть null.");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Стоимость услуги не может быть отрицательной.");
        }
        if (price.scale() > 2) {
            throw new IllegalArgumentException("Стоимость услуги должна иметь не более двух знаков после запятой.");
        }
    }
}
