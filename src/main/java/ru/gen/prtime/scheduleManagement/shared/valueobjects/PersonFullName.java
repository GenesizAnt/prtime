package ru.gen.prtime.scheduleManagement.shared.valueobjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonFullName {
    private String firstname;
    private String surname;
    private String patronymic;
    private String fullName;
    private String surAndFirstname;
    private String surnameAndInitial;

    public PersonFullName(String firstname, String surname, String patronymic) {
        validateField("firstname", firstname);
        validateField("surname", surname);
        validateField("patronymic", patronymic);
        this.firstname = firstname;
        this.surname = surname;
        this.patronymic = patronymic;
        this.fullName = buildFullName(surname, firstname, patronymic);
        this.surAndFirstname = buildSurAndFirstname(surname, firstname);
        this.surnameAndInitial = buildSurnameAndInitial(surname, firstname, patronymic);
    }

    private String buildFullName(String surname, String firstname, String patronymic) {
        return (surname + " " + firstname + " " + patronymic).trim();
    }

    private String buildSurAndFirstname(String surname, String firstname) {
        return (surname + " " + firstname).trim();
    }

    private String buildSurnameAndInitial(String surname, String firstname, String patronymic) {
        return (surname +
                " " +
                Character.toUpperCase(firstname.charAt(0)) +
                ". " +
                Character.toUpperCase(patronymic.charAt(0)) +
                ".").trim();
    }

    private void validateField(String fieldName, String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("Поле '%s' не может быть null или пустым.", fieldName)
            );
        }
    }
}
