package ru.gen.prtime.scheduleManagement.application;

public class AppointmentStateMachine {
//ToDo возможно перенести в папку Общее т.к. будет использоваться и клиентом и специалистом

    //ToDo подумать про статусы и возможные действия из них
    //ToDo проверить галочку "Нужно ли подтверждение клиента?", если спец ставит НЕТ то устанавливается статус CONFIRMED
    //ToDo при статусе CANCELLED сделать таблицу с отметкой инициатора отмены и причины + таблица причин отказа + сообщения для клиента/спеца в ТГ




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


public class StateMachine {
    private State currentState;

    public StateMachine() {
        this.currentState = State.ASLEEP;
    }

    public void handleEvent(String event) {
        switch (currentState) {
            case ASLEEP:
                if (event.equals("wake")) {
                    currentState = State.AWAKE;
                }
                break;
            case AWAKE:
                if (event.equals("sleep")) {
                    currentState = State.ASLEEP;
                }
                break;
        }
    }
}
     */
}
