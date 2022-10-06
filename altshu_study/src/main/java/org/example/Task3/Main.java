package org.example.Task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int arrayLen;
    static int arrayLen2;
    public static void main(String[] args) {

        populateTwoDimensionalArray(readFromConsoleAndPrepareArray());
    }

    private static List readFromConsoleAndPrepareArray() {

        List<Integer> tempArray = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            arrayLen = Integer.parseInt(br.readLine());
            arrayLen2 = Integer.parseInt(br.readLine());
            for (int i = 0; i < arrayLen * arrayLen2; i++) {
                tempArray.add(Integer.valueOf(br.readLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
        tempArray.sort(Comparator.naturalOrder());
        return tempArray;
    }

    private static void populateTwoDimensionalArray(List tempArray) {
        int count = 0;
        int[][] array = new int[arrayLen][arrayLen2];
        for (int i = 0; i < arrayLen; i++) {
            for (int j = 0; j < arrayLen2; j++) {
                array[i][j] = (int) tempArray.get(count);
                count++;
            }
        }
        for (int i = arrayLen - 1; i >= 0; i--) {
            System.out.println();
            for (int j = arrayLen2 - 1; j >= 0; j--) {
                System.out.print(array[i][j]);
            }
        }
    }
}
