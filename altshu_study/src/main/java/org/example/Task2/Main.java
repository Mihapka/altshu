package org.example.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final String TARGET_STR = "Ничего не делай";

    public static void main(String[] args) {

        System.out.println("Что бы поделать?");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                if (br.readLine().equals(TARGET_STR)) {
                    System.out.println("Пойду бездельничать");
                    break;
                }
                System.out.println("Что бы еще поделать?");
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
    }
}
