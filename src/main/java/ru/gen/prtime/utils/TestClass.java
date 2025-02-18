package ru.gen.prtime.utils;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        int mask = 69; // Пример: понедельник (1) и среда (4)
        List<DayOfWeek> weekdays = WeekdayUtils.getWeekdaysFromMask(mask);

        List<DayOfWeek> selectedWeekdays = Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY);
        int newMask = WeekdayUtils.getMaskFromWeekdays(selectedWeekdays);

        System.out.println("Выходные дни: " + weekdays);
        System.out.println("Битовая маска для выбранных дней: " + newMask);

    }

    public class WeekdayUtils {

        public static List<DayOfWeek> getWeekdaysFromMask(int mask) {
            List<DayOfWeek> weekdays = new ArrayList<>();

            for (DayOfWeek day : DayOfWeek.values()) {
                if ((mask & day.getBitValue()) != 0) {
                    weekdays.add(day);
                }
            }
            return weekdays;
        }

        public static int getMaskFromWeekdays(List<DayOfWeek> weekdays) {
            int mask = 0;

            for (DayOfWeek day : weekdays) {
                mask |= day.getBitValue();
            }

            return mask;
        }
    }

    @Getter
    public enum DayOfWeek {
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(4),
        THURSDAY(8),
        FRIDAY(16),
        SATURDAY(32),
        SUNDAY(64);

        private final int bitValue;

        DayOfWeek(int bitValue) {
            this.bitValue = bitValue;
        }

        public static DayOfWeek fromBitValue(int bitValue) {
            for (DayOfWeek day : values()) {
                if (day.getBitValue() == bitValue) {
                    return day;
                }
            }
            throw new IllegalArgumentException("Invalid bit value for DayOfWeek: " + bitValue);
        }
    }
}
