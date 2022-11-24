package org.example.task_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.Arrays;

public class Task_2 {

    public static void main(String[] args) {

        System.out.println();
    }

    private static void secretOfLeapYears() {

        System.out.println("Введите дату.");
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {

            int currentYear = Year.now().getValue();
            String date = buffer.readLine();
            if (dataValidation(date)) {

                int yearOfBirth = Integer.parseInt(date.substring(6, date.length()));

                for (int i = yearOfBirth; i <= currentYear; i ++) {
                   if (isLeapYear(yearOfBirth)){

                   }
                }
            } else {
                System.out.println("Введенные данные некорректны." + "\n" + "Попробуйте еще раз.");
                secretOfLeapYears();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean dataValidation(String data) {

        if (data.matches("\\d")) {

            int[] array = Arrays.stream(data.split("\\."))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            return array[0] > 0 && array[0] < 32 && array[1] > 0 & array[1] < 13 && array[2] > 0 && array[2] < 10000;
        }
        return false;
    }


    private static boolean isLeapYear(int year){
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }
}
