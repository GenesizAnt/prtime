package ru.gen.prtime.scheduleManagement.shared.valueobjects;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.gen.prtime.scheduleManagement.api.dto.schedulerule.AddScheduleRuleRequest;
import ru.gen.prtime.scheduleManagement.infrastructure.entities.ScheduleRuleEntity;

import java.time.Duration;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DailyWorkSchedule {

    private LocalTime startWorkTime;
    private LocalTime endWorkTime;
    private Duration restInterval;
    private Duration baseDurationAppointment;
    private LocalTime startLunchTime;
    private LocalTime endLunchTime;

    public DailyWorkSchedule(ScheduleRuleEntity scheduleRuleEntity) {
        validateStartAndEndWorkTime(scheduleRuleEntity.getStartWorkTime(), scheduleRuleEntity.getEndWorkTime());
        validateRestInterval(scheduleRuleEntity.getRestInterval());
        validateBaseDurationAppointment(scheduleRuleEntity.getBaseDurationAppointment());
        validateStartAndEndLunchTime(scheduleRuleEntity.getStartLunchTime(), scheduleRuleEntity.getEndLunchTime());
        validateLunchTimeWithinWorkTime(scheduleRuleEntity.getStartWorkTime(), scheduleRuleEntity.getEndWorkTime(),
                scheduleRuleEntity.getStartLunchTime(), scheduleRuleEntity.getEndLunchTime());

        this.startWorkTime = scheduleRuleEntity.getStartWorkTime();
        this.endWorkTime = scheduleRuleEntity.getEndWorkTime();
        this.restInterval = scheduleRuleEntity.getRestInterval();
        this.baseDurationAppointment = scheduleRuleEntity.getBaseDurationAppointment();
        this.startLunchTime = scheduleRuleEntity.getStartLunchTime();
        this.endLunchTime = scheduleRuleEntity.getEndLunchTime();
    }

    public DailyWorkSchedule(@Valid AddScheduleRuleRequest scheduleRuleRequest) {
        validateStartAndEndWorkTime(scheduleRuleRequest.startWorkTime(), scheduleRuleRequest.endWorkTime());
        validateRestInterval(scheduleRuleRequest.restInterval());
        validateBaseDurationAppointment(scheduleRuleRequest.baseDurationAppointment());
        validateStartAndEndLunchTime(scheduleRuleRequest.startLunchTime(), scheduleRuleRequest.endLunchTime());
        validateLunchTimeWithinWorkTime(scheduleRuleRequest.startWorkTime(), scheduleRuleRequest.endWorkTime(),
                scheduleRuleRequest.startLunchTime(), scheduleRuleRequest.endLunchTime());

        this.startWorkTime = scheduleRuleRequest.startWorkTime();
        this.endWorkTime = scheduleRuleRequest.endWorkTime();
        this.restInterval = scheduleRuleRequest.restInterval();
        this.baseDurationAppointment = scheduleRuleRequest.baseDurationAppointment();
        this.startLunchTime = scheduleRuleRequest.startLunchTime();
        this.endLunchTime = scheduleRuleRequest.endLunchTime();
    }

    private void validateStartAndEndWorkTime(LocalTime startWorkTime, LocalTime endWorkTime) {
        if (startWorkTime == null) {
            throw new IllegalArgumentException("Время начала работы не может быть равным null");
        }
        if (endWorkTime == null) {
            throw new IllegalArgumentException("Время окончания работы не может быть null");
        }
        if (!startWorkTime.isBefore(endWorkTime)) {
            throw new IllegalArgumentException("Время начала работы должно быть до окончания рабочего времени");
        }
    }

    private void validateRestInterval(Duration restInterval) {
        if (restInterval == null) {
            throw new IllegalArgumentException("Интервал отдыха не может быть равен нулю");
        }
        if (restInterval.isNegative() || restInterval.isZero()) {
            throw new IllegalArgumentException("Интервал отдыха должен быть положительным");
        }
    }

    private void validateBaseDurationAppointment(Duration baseDurationAppointment) {
        if (baseDurationAppointment == null) {
            throw new IllegalArgumentException("Стандартная продолжительность приема не может быть null");
        }
        if (baseDurationAppointment.isNegative() || baseDurationAppointment.isZero()) {
            throw new IllegalArgumentException("Стандартная продолжительность приема должна быть положительная");
        }
    }

    private void validateStartAndEndLunchTime(LocalTime startLunchTime, LocalTime endLunchTime) {
        if (startLunchTime == null) {
            throw new IllegalArgumentException("Время начала обеда не может быть null");
        }
        if (endLunchTime == null) {
            throw new IllegalArgumentException("Окончание обеденного перерыва не может быть null");
        }
        if (!startLunchTime.isBefore(endLunchTime)) {
            throw new IllegalArgumentException("Обеденное время должно начинаться до окончания обеденного перерыва");
        }
    }

    private void validateLunchTimeWithinWorkTime(LocalTime startWorkTime, LocalTime endWorkTime,
                                                 LocalTime startLunchTime, LocalTime endLunchTime) {
        if (!startLunchTime.isAfter(startWorkTime) || !endLunchTime.isBefore(endWorkTime)) {
            throw new IllegalArgumentException("Обеденное время должно входить с рабочее время");
        }
    }
}