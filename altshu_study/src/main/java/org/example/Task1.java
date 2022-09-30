package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Task1 {
    static long nonTaxableIncome = 42500L;
    static double tax = 13.0;

    public static void main(String[] args) {

        depositCalculation(readDataFromConsole());
    }

    public static double[] readDataFromConsole() {

        double[] data = new double[3];
        String[] line = {"enter the deposited amount",
                "Shelf life of funds (number of years)",
                "Interest rate (% per annum)"

        };

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < line.length; i++) {
                System.out.println(line[i]);
                data[i] = Double.parseDouble(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong...");
        }
//        Arrays.stream(data).forEach(System.out::println);
        return data;
    }

    private static void depositCalculation(double[] data) {

        double income = data[0] / 100 * data[2];
        double taxablePortion = income - nonTaxableIncome;
        double incomeAfterTax = 0L;
        double deposit = data[0];
        for (int year = 1; year <= data[1]; year++) {
            if (taxablePortion > nonTaxableIncome) {
                taxablePortion = income - nonTaxableIncome;
                incomeAfterTax = taxablePortion - taxablePortion / 100 * tax + nonTaxableIncome;
                System.out.println("За " + year + " год, прибыль составила: "
                        + new DecimalFormat("#0.00").format(incomeAfterTax));
                deposit += incomeAfterTax;
                income = deposit / 100 * data[2];

            } else {
                income = deposit / 100 * data[2];

                System.out.println("За " + year + " год, прибыль составила: "
                        + new DecimalFormat("#0.00").format(income));
                deposit += income;
            }
        }
    }
}

