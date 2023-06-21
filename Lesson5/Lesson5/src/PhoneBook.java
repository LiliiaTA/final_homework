import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "John Doe", "1234567890");
        addContact(phoneBook, "Jane Smith", "9876543210");
        addContact(phoneBook, "John Doe", "5555555555");
        addContact(phoneBook, "Jane Smith", "1111111111");
        addContact(phoneBook, "John Doe", "9999999999");

        // Вывод телефонной книги
        System.out.println("Телефонная книга:");
        printPhoneBook(phoneBook);

        // Сортировка по убыванию числа телефонов
        List<Map.Entry<String, Set<String>>> sortedList = sortPhoneBook(phoneBook);

        // Вывод отсортированной телефонной книги
        System.out.println("\nОтсортированная телефонная книга:");
        printSortedPhoneBook(sortedList);
    }

    private static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        Set<String> phoneNumbers = phoneBook.getOrDefault(name, new HashSet<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }

    private static void printPhoneBook(Map<String, Set<String>> phoneBook) {
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();
            System.out.println("Имя: " + name);
            System.out.println("Телефоны: " + phoneNumbers);
            System.out.println();
        }
    }

    private static List<Map.Entry<String, Set<String>>> sortPhoneBook(Map<String, Set<String>> phoneBook) {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        return entries;
    }

    private static void printSortedPhoneBook(List<Map.Entry<String, Set<String>>> sortedList) {
        for (Map.Entry<String, Set<String>> entry : sortedList) {
            String name = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();
            System.out.println("Имя: " + name);
            System.out.println("Телефоны: " + phoneNumbers);
            System.out.println();
        }
    }
}
