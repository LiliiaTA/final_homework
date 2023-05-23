package org.hse.example;

/**
 * Вычисляет количество счастливых билетов
 */
public class Main {
    public static void main(String[] args) {
        Counter counterSix = new Counter(6);
        System.out.printf("Всего %d счастливых билетов", counterSix.getLuckyTicketsAmount());
    }
}