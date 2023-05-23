package org.hse.example;

/**
 * Вычисляет количество счастливых билетов заданной длины
 */
public class Counter {
    private final int length;

    public Counter(int length) {
        this.length = length;
    }

    /**
     * Вычисляет количество счастливых билетов с номерами заданной длины
     *
     * @return количество счастливых билетов
     */
    public int getLuckyTicketsAmount() {
        int result = 0;
        for (int i = 0; i < Math.pow(10, getLength()); i++) {
            Lucky ticket = getInstance(getLength(), i);
            if (ticket.isLucky()) {
                result++;
            }
        }
        return result;
    }

    protected Lucky getInstance(final int length, final int number) {
        return new TicketImpl(length, number);
    }

    public int getLength() {
        return length;
    }
}
