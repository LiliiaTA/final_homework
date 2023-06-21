import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        // Добавление контактов в телефонную книгу
        addContact(phoneBook, "John Doe", "1234567890");
        addContact(phoneBook, "Jane Smith", "9876543210");
        addContact(phoneBook, "John Doe", "5555555555");
        addContact(phoneBook, "Jane Smith", "1111111111");
        addContact(phoneBook, "John Doe", "9999999999");

        // Вывод телефонной книги
        System.out.println("Телефонная книга (сортировка по убыванию числа телефонов):");
        printSortedPhoneBook(phoneBook);
    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }

    private static void printSortedPhoneBook(Map<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());

        // Сортировка по убыванию числа телефонов
        Collections.sort(sortedEntries, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
            }
        });

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println("Имя: " + name);
            System.out.println("Телефоны: " + phoneNumbers);
            System.out.println();
        }
    }
}
