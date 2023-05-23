package org.hse.example;

/**
 * Утилитные методы для работы с билетами
 */
public final class TicketUtils {
    private TicketUtils() {
        throw new RuntimeException("Класс содердит только утилитные методы. Создание экземпляров запрещено!");
    }

    /**
     * Взвращает сумму цифр переданного числа
     *
     * @param number число, для кторого ищем сумму цифр
     * @return сумма цифр
     */
    public static int getDigitsSum(final int number) {
        int sum = 0;
        for (int tmp = number; tmp > 0; tmp = tmp / 10) {
            sum = sum + tmp % 10;
        }

        return sum;
    }

}
