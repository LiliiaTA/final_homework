import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(3);
        numbers.add(6);
        numbers.add(1);

        // Удаление чётных чисел
        removeEvenNumbers(numbers);

        // Нахождение минимального значения
        int min = findMinValue(numbers);

        // Нахождение максимального значения
        int max = findMaxValue(numbers);

        // Нахождение среднего значения
        double average = findAverageValue(numbers);

        System.out.println("Список после удаления чётных чисел: " + numbers);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }

    private static void removeEvenNumbers(List<Integer> numbers) {
        numbers.removeIf(n -> n % 2 == 0);
    }

    private static int findMinValue(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static int findMaxValue(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static double findAverageValue(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }
}
