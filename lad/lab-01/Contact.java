import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contact {
    public static void main(String[] args) {
        List<String> contactsInPhone = new ArrayList<>(List.of("Ivan", "Maria", "Alex", "Oleg"));
        List<String> contactsInSim = new ArrayList<>(List.of("Maria", "Dmitry", "Oleg", "Elena"));

        List<String> allContacts = new ArrayList<>();

        for (String name : contactsInPhone) {
            if (!allContacts.contains(name)) {
                allContacts.add(name);
            }
        }

        for (String name : contactsInSim) {
            if (!allContacts.contains(name)) {
                allContacts.add(name);
            }
        }

        Collections.sort(allContacts);

        System.out.println("Синхронизированный список: " + allContacts);
    }
}