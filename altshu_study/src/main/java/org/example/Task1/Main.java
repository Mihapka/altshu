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
            System.out.println("Enter the number of numbers to read");
            numberOfDigits = Integer.parseInt(br.readLine());
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < numberOfDigits; i++) {
                numbers.add(Integer.parseInt((br.readLine())));
            }
            Collections.sort(numbers);
            System.out.println("Entered numbers:");
            numbers.forEach(System.out::print);
            System.out.println();
            return numbers;

        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
    }

    private static void printMatchesToConsole(List<Integer> numbers) {

        Map<Integer, Long> map = numbers.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<Integer, Long> mapSortedByValue = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        mapSortedByValue.entrySet().stream()
                .map(e -> " " + e.getKey() + " " + e.getValue())
                .forEach(System.out::println);

        System.out.println("Output result:");
        for (Map.Entry<Integer, Long> entry : mapSortedByValue.entrySet()) {
            if (entry.getValue() > 1) {
                for (int i = 0; i < entry.getValue(); i++) {
                    System.out.print(entry.getKey() + " ");
                }
                System.out.println();
            }
        }

        System.out.print("Unique numbers: ");
        mapSortedByValue.entrySet().stream()
                .filter(x-> x.getValue()<2)
                .forEach(x -> System.out.print(x.getKey() + " "));
    }
}
