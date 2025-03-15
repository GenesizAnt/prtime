package ru.gen.prtime.scheduleManagement.domain.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.regex.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhoneNumber {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(
            "^\\+?[1-9]\\d{1,14}$"
    );

    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Номер телефона не может быть null");
        }
        if (phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер телефона не может быть пустым");
        }
        if (!PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Некорректный формат номера телефона");
        }
        if (phoneNumber.length() < 10 || phoneNumber.length() > 15) {
            throw new IllegalArgumentException("Номер телефона должен быть в пределах 10-15 символов");
        }
    }
}
