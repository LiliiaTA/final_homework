package org.hse.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


/**
 * Сущность Билет
 */
public interface Ticket extends Lucky {

    int getLength();

    int getNumber();

}
/**
 * Реализация Сущности Билет
 */
class TicketImpl implements Ticket {

    /**
     * Количество цифр в номере билета
     */
    private final int length;

    /**
     * Номер билета
     */
    private final int number;
    private final Map<String, Integer> map;

    public TicketImpl(int length, int number) {
        this.length = length;
        this.number = number;

        map = new HashMap<>() {
            {
                put("1", 1);
                put("2", 2);
                put("3", 3);
            }
        };
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getNumber() {
        return number;
    }

    /**
     * Вычисляет, является ли билет счастливым
     *
     * @return true, если является
     */
    @Override
    public boolean isLucky() {
        int middle = getLength() / 2;
        int half = Double.valueOf(Math.pow(10, middle)).intValue();

        int first = TicketUtils.getDigitsSum(getNumber() / half);
        int last = TicketUtils.getDigitsSum(getNumber() % half);

        return first == last;
    }
}
