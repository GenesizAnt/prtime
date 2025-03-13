package ru.gen.prtime.scheduleManagement.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.gen.prtime.scheduleManagement.domain.model.Specialist;
import ru.gen.prtime.scheduleManagement.infrastructure.adapters.UserAdapter;

@Service
@RequiredArgsConstructor
public class SpecialistModelService {

    private final UserAdapter userAdapter;

    public Specialist getSpecialistById(Long userId) {
        Specialist specialist = userAdapter.getSpecialistById(userId);
    }


    /*

    public Specialist getSpecialistById(Long userId) {
        // Получаем данные из репозиториев
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        List<TimeSlot> timeSlots = timeSlotRepository.findTimeSlotsByUserId(userId);
        List<ScheduleRule> scheduleRules = scheduleRulesRepository.findRulesByUserId(userId);

        // Преобразуем данные в доменную модель
        PersonFullName fullName = new PersonFullName(
                user.getFirstName(),
                user.getLastName(),
                user.getPatronymic()
        );

        Calendar calendar = buildCalendar(timeSlots, scheduleRules);
        List<Client> clients = mapClients(user.getClients());

        return new Specialist(
                user.getId(),
                fullName,
                calendar,
                clients
        );
    }

    /*
        public Client toClient() {
        return new Client(this.id, new PersonFullName(this.firstname, this.surname, this.patronymic), Boolean.TRUE);
    }

    public Specialist toSpecialist() {
        return new Specialist(this.id, new PersonFullName(this.firstname, this.surname, this.patronymic));
    }


    /*
    // Методы для преобразования в доменную модель и обратно
    public User toDomain() {
        return new User(this.id, this.username, this.email);
    }

    public static UserEntity fromDomain(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        return entity;
    }

     */
}
