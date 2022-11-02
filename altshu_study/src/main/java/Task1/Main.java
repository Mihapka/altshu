package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final String TARGET_STR = "Достаточно";
    static Map<String, List<Animal>> testList = new HashMap<>();

    public static void main(String[] args) {

        consoleOutput(readingFromConsole());
    }

    public static Map<String, List<Animal>> readingFromConsole() {

        boolean flag = true;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String animalType;
            String animalName;

            while (flag) {

                System.out.println("введите тип животного");
                animalType = br.readLine();

                System.out.println("введите имя животного");
                animalName = br.readLine();

                if (animalName.equals(TARGET_STR) | animalType.equals(TARGET_STR)) {
                    flag = false;
                    return testList;
                }

                switch (animalType.toLowerCase()) {
                    case ("cat") -> addToList(animalName, new Cat(animalName));
                    case ("cow") -> addToList(animalName, new Cow(animalName));
                    case ("dog") -> addToList(animalName, new Dog(animalName));
                    case ("snake") -> addToList(animalName, new Snake(animalName));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
        return testList;
    }

    public static synchronized void addToList(String mapKey, Animal myItem) {
        List<Animal> itemsList = testList.get(mapKey);

        if (itemsList == null) {
            itemsList = new ArrayList<>();
            itemsList.add(myItem);
            testList.put(mapKey, itemsList);
        } else {
            if (!itemsList.contains(myItem)) itemsList.add(myItem);
        }
    }

    public static void consoleOutput(Map<String, List<Animal>> map) {
        for
        (String name : map.keySet()) {
            map.get(name).forEach(Animal::tellMeWhoYouAre);
            System.out.println();
        }
//        System.out.println("------");
//        map.keySet().forEach(System.out::println);
    }
}
