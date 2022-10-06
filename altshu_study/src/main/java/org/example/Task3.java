package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class Task3 {

    static List<Integer> listOfNumbers = new ArrayList<>();

    public static void main(String[] args) {

        readingFromConsole();
        for (Integer i : listOfNumbers) {
            System.out.println(isFibonacciNumber(i) ? i + " is Fibonacci" : i + " is NOT Fibonacci");
        }
    }

    public static int readingFromConsole() {

        int number;
        System.out.println("enter number of numbers");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            number = Integer.parseInt(br.readLine());
            System.out.println("number is: " + number);
            for (int i = 0; i < number; i++) {
                listOfNumbers.add(Integer.parseInt(br.readLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
        sort(listOfNumbers);
        listOfNumbers.forEach(System.out::println);
        return number;
    }

    /*число N является числом Фибоначчи тогда и только тогда, когда 5*N*N - 4 является квадратом*/
    private static boolean isFibonacciNumber(long num) {
        double tmp = 5 * num * num - 4;
        double sq = (long) Math.sqrt(tmp);
        return sq * sq == tmp;
    }
}
