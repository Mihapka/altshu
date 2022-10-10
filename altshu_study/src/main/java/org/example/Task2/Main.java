package org.example.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static double[] numbers = new double[3];

    public static void main(String[] args) {

        readingFromConsole();
        isExists(numbers);
    }

    private static void readingFromConsole() {


        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите количество чисел, которые будете считывать");
            for (int i = 0; i < 3; i++) {
                numbers[i] = (Double.parseDouble(br.readLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
    }

    private static void isExists(double[] numbers) {

        System.out.println((numbers[0] < numbers[1] + numbers[2]
                && numbers[1] < numbers[0] + numbers[2]
                && numbers[2] < numbers[0] + numbers[1]) ? "Треугольник существует" : "Треугольник НЕсуществует");
    }
}
