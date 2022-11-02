package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static final String TARGET_STR = "qqq";

    static List<Animal> animalList = new ArrayList<>();

    public static void main(String[] args) {

        consoleOutput(readingFromConsole());
    }

    public static List<Animal> readingFromConsole() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            boolean flag = true;
            String animalTypeStr;
            String animalName;
            int animalAge;
            Animal.AnimalType animalType;

            while (flag) {

                System.out.println("введите тип животного");
                animalTypeStr = br.readLine();

                if (animalTypeStr.equals(TARGET_STR)) {
                    flag = false;
                    return animalList;
                }
                animalType = Animal.AnimalType.valueOf(animalTypeStr);
                System.out.println("введите имя животного");
                animalName = br.readLine();

                System.out.println("введите возраст животного");
                animalAge = Integer.parseInt(br.readLine());

                switch (animalType) {
                    case cat -> {
                        Animal cat = new Cat(animalType, animalName, animalAge);
                        animalList.add(cat);
                    }
                    case cow -> {
                        Animal cow = new Cow(animalType, animalName, animalAge);
                        animalList.add(cow);
                    }
                    case dog -> {
                        Animal dog = new Dog(animalType, animalName, animalAge);
                        animalList.add(dog);
                    }
                    case snake -> {
                        Animal snake = new Snake(animalType, animalName, animalAge);
                        animalList.add(snake);
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
        return animalList;
    }

    public static void consoleOutput(List<Animal> animalList) {

        animalList.stream()
                .sorted(Comparator.comparing(Animal::getType)
                        .thenComparing(Animal::getAge)
                        .thenComparing(Animal::getName))
                .forEach(Animal::tellMeWhoYouAre);

    }
}
