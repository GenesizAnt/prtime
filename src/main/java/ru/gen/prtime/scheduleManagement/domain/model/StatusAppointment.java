package ru.gen.prtime.scheduleManagement.domain.model;

public enum StatusAppointment {
    //ToDo подумать про статусы и возможные действия из них
    //ToDo проверить галочку "Нужно ли подтверждение клиента?", если спец ставит НЕТ то устанавливается статус CONFIRMED
    //ToDo при статусе CANCELLED сделать таблицу с отметкой инициатора отмены и причины + таблица причин отказа + сообщения для клиента/спеца в ТГ

    /*
    CREATED
    NEED_CONFIRMED_SPECIALIST
    NEED_CONFIRMED_CLIENT
    CONFIRMED
    COMPLETED
    CANCELLED
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
