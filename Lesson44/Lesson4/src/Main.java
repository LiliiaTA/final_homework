import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class User {
    private String fullName;
    private int age;
    private String gender;

    public User(String fullName, int age, String gender) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getFormattedInfo() {
        String[] nameParts = fullName.split(" ");
        StringBuilder initials = new StringBuilder();
        for (int i = 1; i < nameParts.length; i++) {
            initials.append(nameParts[i].charAt(0)).append(".");
        }
        return nameParts[0] + " " + initials + " " + age + " " + gender;
    }
}

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Введите ФИО пользователя (или 'exit' для выхода, 'sort' для сортировки по возрасту):");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                exit = true;
                continue;
            } else if (input.equalsIgnoreCase("sort")) {
                Collections.sort(users, Comparator.comparingInt(User::getAge));
                System.out.println("Список пользователей, отсортированный по возрасту:");
                for (User user : users) {
                    System.out.println(user.getFormattedInfo());
                }
                continue;
            }

            String fullName = input;

            System.out.println("Введите возраст пользователя:");
            int age = scanner.nextInt();
            scanner.nextLine(); // Считывание символа новой строки после ввода числа

            System.out.println("Введите пол пользователя:");
            String gender = scanner.nextLine();

            User user = new User(fullName, age, gender);
            users.add(user);

            System.out.println("Пользователь успешно добавлен.");
        }

        // Вывод списка пользователей в формате Фамилия И.О. возраст пол
        System.out.println("Список пользователей:");
        for (User user : users) {
            System.out.println(user.getFormattedInfo());
        }

        scanner.close();
    }
}
