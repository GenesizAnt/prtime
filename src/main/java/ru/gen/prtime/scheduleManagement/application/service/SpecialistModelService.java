package ru.gen.prtime.scheduleManagement.application.service;

public class SpecialistModelService {

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



    /*
    private final UserRepository userRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final CabinetsScheduleRulesRepository scheduleRulesRepository;

    public SpecialistService(UserRepository userRepository,
                             TimeSlotRepository timeSlotRepository,
                             CabinetsScheduleRulesRepository scheduleRulesRepository) {
        this.userRepository = userRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.scheduleRulesRepository = scheduleRulesRepository;
    }

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

    private Calendar buildCalendar(List<TimeSlot> timeSlots, List<ScheduleRule> scheduleRules) {
        // Логика построения календаря на основе временных слотов и правил
        return new Calendar(timeSlots, scheduleRules);
    }

    private List<Client> mapClients(List<User> clientUsers) {
        // Преобразование пользователей в клиентов
        return clientUsers.stream()
                .map(clientUser -> new Client(
                        clientUser.getId(),
                        clientUser.getFullName()
                ))
                .toList();
    }
     */
}
