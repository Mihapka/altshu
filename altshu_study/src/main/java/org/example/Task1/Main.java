package org.example.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
//    static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {

        printMatchesToConsole(readingFromConsole());
    }

    private static List<Integer> readingFromConsole() {

        int numberOfDigits;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите количество чисел, которые будете считывать");
            numberOfDigits = Integer.parseInt(br.readLine());
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < numberOfDigits; i++) {
                numbers.add(Integer.parseInt((br.readLine())));
            }
            System.out.println("Введёные числа:");
            numbers.forEach(System.out::println);
//            return Arrays.stream(numbers).sorted().toArray();
            return numbers;
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
    }

    private static void printMatchesToConsole(List<Integer> numbers) {

//        Map<String, String> map = new HashMap<>();
//        for (String number : numbers) {
//            if (map.containsKey(number)) {
//                map.put(number, map.get(number) + " " + number);
//            } else {
//                map.put(number, number);
//            }
//        }
        Map<Integer, Long> map = numbers.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<Integer, Long> mapSortedByValue = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        // TODO вывести в консоль
    }
}
