package ru.gen.prtime.scheduleManagement.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.domain.valueobjects.DateTimeParameters;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OpenTimeWindow {

    //ToDo Нужно ли добавить Предпочтительное время для специалиста, устанавливает сам спец?
    private Long timeSlotId;
    private DateTimeParameters dateTimeParameters;
    private StatusTimeSlot statusTimeSlot;
    private LocalDateTime lockedAt;
    private Specialist specialist;
    private List<SpecialistServiceModel> availableServiceList;
}
