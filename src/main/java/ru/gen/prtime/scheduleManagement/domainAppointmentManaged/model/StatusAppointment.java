package ru.gen.prtime.scheduleManagement.domainAppointmentManaged.model;

public enum StatusAppointment {
    CREATED,
    NEED_CONFIRMED_SPECIALIST,
    NEED_CONFIRMED_CLIENT,
    CONFIRMED,
    COMPLETED,
    CANCELLED



    /*
[CREATED]
   │
   ├───(Специалист подтверждает)───────> [NEED_CONFIRMED_CLIENT]
   │
   └───(Клиент подтверждает)───────────> [NEED_CONFIRMED_SPECIALIST]

[NEED_CONFIRMED_CLIENT]
   │
   └───(Клиент подтверждает)───────────> [CONFIRMED]

[NEED_CONFIRMED_SPECIALIST]
   │
   └───(Специалист подтверждает)───────> [CONFIRMED]

[CONFIRMED]
   │
   ├───(Приём завершён)─────────────────> [COMPLETED]
   │
   └───(Отмена приёма)─────────────────> [CANCELLED]
     */

}
