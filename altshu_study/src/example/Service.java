package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Service {

    public void work() {

        System.out.println("""
                1 - Вывести всех людей и их данные

                2 - Найти человека по имени, номеру телефона, электронной почте

                3 - Добавить человека

                4 - Удалить человека с определенным номером телефона

                5 - Редактировать данные участника с определенным номером телефона.

                6 - Завершить выполнение""");
        while (true){
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
