package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.CabinetEntity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cabinet {

    private Long id;
    private String cabinetName;
    private String cabinetAddress;
    private String cabinetDescription;

    public Cabinet(CabinetEntity cabinet) {
        validateCabinetName(cabinet.getCabinetName());
        validateCabinetAddress(cabinet.getCabinetAddress());
        validateCabinetDescription(cabinet.getCabinetAddress());

        this.id = cabinet.getId();
        this.cabinetName = cabinet.getCabinetName();
        this.cabinetAddress = cabinet.getCabinetAddress();
        this.cabinetDescription = cabinet.getCabinetDescription();
    }

    private void validateCabinetName(String cabinetName) {
        if (cabinetName == null || cabinetName.trim().isEmpty()) {
            throw new IllegalArgumentException("Название кабинета не может быть null или пустым.");
        }
        if (cabinetName.length() > 100) {
            throw new IllegalArgumentException("Название кабинета не должно превышать 100 символов.");
        }
    }

    private void validateCabinetAddress(String cabinetAddress) {
        if (cabinetAddress == null || cabinetAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Адрес кабинета не может быть null или пустым.");
        }
        if (cabinetAddress.length() > 255) {
            throw new IllegalArgumentException("Адрес кабинета не должен превышать 255 символов.");
        }
    }

    private void validateCabinetDescription(String cabinetDescription) {
        if (cabinetDescription != null && cabinetDescription.length() > 500) {
            throw new IllegalArgumentException("Описание кабинета не должно превышать 500 символов.");
        }
    }
}
