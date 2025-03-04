package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Specialist {

    private Long userId;
    private PersonFullName fullName;
    private Calendar calendar;
    private List<Client> clients;

    public Specialist(Long userId, PersonFullName fullName) {
        this.userId = userId;
        this.fullName = fullName;
    }
}
