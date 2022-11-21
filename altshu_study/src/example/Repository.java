package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {

    Map<String, Person> repo = new HashMap<>();

    public Repository() {

    }

    public boolean keyVerification(String key) {
        return repo.containsKey(key);
    }

    public void showAllUsers() {
        for (var entry : repo.entrySet()) {
            System.out.println(entry.toString());
        }
    }

    public Person searchByPhoneNumber(String phoneNumber) {

        return repo.getOrDefault(phoneNumber, null);
    }

    public Person searchByEmail(String searchData) {

        for (Person key : repo.values()) {
            for (String str : key.getEmails()) {
                if (searchData.equalsIgnoreCase(str)) {
                    return key;
                }
            }
        }
        return null;
    }

    public List<Person> searchByFirstOrLastName(String name) {

        List<Person> listOfPerson = new ArrayList<>();
        for (Person key : repo.values()) {
            if (name.equalsIgnoreCase(key.getFirstname())
                    || name.equalsIgnoreCase(key.getSurname())) {
                listOfPerson.add(key);
            }
        }
        return listOfPerson;
    }

    public void addEntry(Person person) {

        repo.put(person.getPhoneNumber(), person);
    }

    public void deleteEntryByPhoneNumber(String phoneNumber) {

        repo.remove(phoneNumber);
    }

}
