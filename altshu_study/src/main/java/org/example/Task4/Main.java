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
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.size(); j++) {
                if (isAnagram((String) array.get(i), (String) array.get(j)) == 1) {
                    if (!anagramsArray.contains(array.get(i))) {
                        anagramsArray.add((String) array.get(i));
                    }
                    if (!anagramsArray.contains(array.get(j))) {
                        anagramsArray.add((String) array.get(j));
                    }
                }
            }
        }
        for (int i = 0; i < array.size(); i++) {
            if (!anagramsArray.contains(array.get(i))){
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
        if (Arrays.equals(charArray1, charArray2)) {
            return 1;
        }
        return -2;
    }
}
