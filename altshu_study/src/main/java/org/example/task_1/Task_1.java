package org.example.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.*;
import java.util.Arrays;
import java.util.Locale;


public class Task_1 {

    public static void main(String[] args) {

        dayOfWeekSearch();
    }

    private static void dayOfWeekSearch() {

        LocalDate localDate;
        DateTimeFormatter dateTimeFormatter01 = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println("Введите дату в формате \"dd.MM.yyyy\", например: 20.02.2002");

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {

            String data = buffer.readLine();
            if (dataValidation(data)) {
                localDate = LocalDate.parse(data, dateTimeFormatter01);
                System.out.println("Это " + localDate.getDayOfWeek().getValue()
                        + "-й день недели: "
                        + localDate.getDayOfWeek()
                        .getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru")));
            } else {
                System.out.println("Введенные данные некорректны." + "\n" + "Попробуйте еще раз.");
                dayOfWeekSearch();
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
}
