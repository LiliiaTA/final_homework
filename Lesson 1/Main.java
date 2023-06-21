import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int i = getRandomNumber(0, 2000);
        System.out.println("Случайное число i: " + i);

        int n = findHighestSetBit(i);
        System.out.println("Номер старшего значащего бита: " + n);

        int[] m1 = findMultiples(i, n, i, Short.MAX_VALUE);
        System.out.println("Числа, кратные n, в диапазоне от i до Short.MAX_VALUE:");
        printArray(m1);

        int[] m2 = findNonMultiples(i, n, Short.MIN_VALUE, i);
        System.out.println("Числа, некратные n, в диапазоне от Short.MIN_VALUE до i:");
        printArray(m2);
    }

    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static int findHighestSetBit(int number) {
        if (number == 0) {
            return 0;
        }

        int position = 1;
        while (number > 1) {
            number = number >> 1;
            position++;
        }

        return position;
    }

    private static int[] findMultiples(int number, int divisor, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % divisor == 0) {
                count++;
            }
        }

        int[] multiples = new int[count];
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (i % divisor == 0) {
                multiples[index++] = i;
            }
        }

        return multiples;
    }

    private static int[] findNonMultiples(int number, int divisor, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % divisor != 0) {
                count++;
            }
        }

        int[] nonMultiples = new int[count];
        int index = 0;
        for (int i = start; i <= end; i++) {
            if (i % divisor != 0) {
                nonMultiples[index++] = i;
            }
        }

        return nonMultiples;
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
