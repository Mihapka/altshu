package org.example.Task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {
        searchForMultiples(readingFromConsole());
    }

    private static int[] readingFromConsole() {

        List<String> manual = Arrays.asList("Enter three numbers:",
                "1st is the number that is the beginning of the sequence.",
                "2nd is the number that is the end of the sequence.",
                "The 3rd is the number for checking the multiplicity.");

        int[] numbers = new int[3];

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            manual.forEach(System.out::println);
            for (int i = 0; i < 3; i++) {
                numbers[i] = (Integer.parseInt(br.readLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
        return numbers;
    }

    private static void searchForMultiples(int[] numbers) {
        System.out.printf("Multiples \"%s\":\n", numbers[2]);
        IntStream.range(numbers[0], numbers[1])
                .filter(i -> i % numbers[2] == 0)
                .forEach(System.out::println);
    }
}
