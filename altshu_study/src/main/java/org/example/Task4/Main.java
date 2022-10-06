package org.example.Task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        fillArrays(readingFromConsole());
    }

    private static List readingFromConsole() {

        int wordCount;
        List<String> wordsArray = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите количество слов");
            wordCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < wordCount; i++) {
                wordsArray.add(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
        return wordsArray;
    }

    private static void fillArrays(List array) {

        List<String> anagramsArray = new ArrayList<>();
        List<String> notAnagramsArray = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (isAnagram((String) array.get(i - 1), (String) array.get(i)) > 0) {
                anagramsArray.add((String) array.get(i));
                anagramsArray.add((String) array.get(i - 1));
            }
            if (isAnagram((String) array.get(i - 1), (String) array.get(i)) == 0) {
                notAnagramsArray.add((String) array.get(i));
            }

        }
        System.out.println("anagrams is: ");
        anagramsArray.forEach(System.out::println);
        System.out.println("not anagrams is: ");
        notAnagramsArray.forEach(System.out::println);

    }

    private static int isAnagram(String str1, String str2) {
        if (str1.equals(str2)) {
            return -1;
        }
        if (str1.length() != str2.length()) {
            return 0;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return 1;
    }
}
