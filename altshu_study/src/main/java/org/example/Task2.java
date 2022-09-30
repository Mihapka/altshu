package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {

        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(readingFromConsole())
                .map(y -> y[0])
                .forEach(System.out::println);
    }

    public static int readingFromConsole() {
        int number = 0;
        System.out.println("enter Fibonacci number");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            number = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
        return number;
    }
}
