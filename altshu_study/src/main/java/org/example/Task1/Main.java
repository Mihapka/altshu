package org.example.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {

    static final String TARGET_STR = "отстань от меня, пожалуйста";

    public static void main(String[] args) {

        exceptional();
    }

    private static void exceptional() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите строку");
            while (true) {
                if (br.readLine().toLowerCase(Locale.ROOT).equals(TARGET_STR)) {
                    throw new IOException("Ха-ха! Попался! я поймал исключение");
                }
                System.out.println("Давай попробуем снова");
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("До свидания");
        }
    }
}