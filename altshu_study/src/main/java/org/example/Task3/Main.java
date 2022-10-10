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

        List<String> manual = Arrays.asList("Введите три числа:",
                "1-е - это число, которое является началом последовательности.",
                "2-е - это число, которое является концом последовательности.",
                "3-е - это число для сверки кратности.");

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
        System.out.printf("Числа кратные \"%s\":\n", numbers[2]);
        IntStream.range(numbers[0], numbers[1])
                .filter(i -> i % numbers[2] == 0)
                .forEach(System.out::println);

//        int[] list = IntStream.range(numbers[0], numbers[1])
//                .filter(i -> i % numbers[2] == 0)
//                .toArray();
//        System.out.printf("Числа кратные %s:\n", numbers[2]);
//        for (int i : list) {
//            System.out.print(i + " ");
//        }
    }
}
