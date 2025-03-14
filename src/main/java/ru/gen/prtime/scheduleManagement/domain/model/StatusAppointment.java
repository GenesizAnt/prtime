package ru.gen.prtime.scheduleManagement.domain.model;

public enum StatusAppointment {
    //ToDo подумать про статусы и возможные действия из них
    /*
    SCHEDULED,      // Встреча запланирована
    CONFIRMED,      // Встреча подтверждена
    RESCHEDULED,    // Встреча перенесена
    CANCELLED,      // Встреча отменена
    COMPLETED       // Встреча завершена


    PENDING (Ожидание подтверждения):
Клиент запросил запись, но она ещё не подтверждена (например, требуется подтверждение специалиста или оплата).
CANCELLED (Отменён):
Запись на этот слот была отменена.
Возможно, слот снова станет доступным для записи.
UNAVAILABLE (Недоступен):
Временной слот недоступен по техническим причинам (например, система выключена или специалист не работает).
OVERBOOKED (Перебронь):
Временной слот был перебронирован (например, при ошибке системы или особых условиях).
    */


    /*
    CREATED (+назначена клиентом, назначена спецом)
   │        ветка с подтверждением другой стороны (подтверждено спецом, если назначена клиентом)
   ├──► CONFIRMED
   │        │
   │        ├──► CANCELLED
   │        ├──► RESCHEDULED
   │        └──► IN_PROGRESS
   │                    │
   │                    ├──► COMPLETED
   │                    └──► NO_SHOW
   │
   └──► CANCELLED
   └──► ARCHIVED

   предоплата и нотификация?

   Из CREATED:
Переход в CONFIRMED: Пациент подтвердил запись.
Переход в CANCELLED: Пациент или администратор отменил запись.
Переход в ARCHIVED: Запись архивирована (например, если не была подтверждена в течение определённого времени).
    Из CONFIRMED:
Переход в CANCELLED: Пациент или администратор отменил запись.
Переход в RESCHEDULED: Запись перенесена на другое время.
Переход в IN_PROGRESS: Приём начался.
    Из IN_PROGRESS:
Переход в COMPLETED: Приём успешно завершён.
Переход в NO_SHOW: Пациент не явился на приём.
    Из CANCELLED, COMPLETED, NO_SHOW:
Переход в ARCHIVED: Запись архивирована (например, через определённое время после завершения или отмены).

     */

}
