package com.chang;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    static final byte PERCENT = 100;
    static final byte MONTHS_IN_YEAR = 12;

    public static double calculatBalance(int principle, float rate, byte years,
        short numberOfPaymentsMade) {
        float monthlyRate = rate / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        return principle * (Math.pow(1 + monthlyRate, numberOfPayments) - Math.pow(1 + monthlyRate,
            numberOfPaymentsMade)) / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }

    public static double calculatMortgage(int principle, double rate, int years) {
        double monthlyRate = rate / PERCENT / MONTHS_IN_YEAR;
        double pow = Math.pow((1 + monthlyRate), years * MONTHS_IN_YEAR);

        return principle * ((monthlyRate * pow) / (pow - 1));
    }

    public static double readNumber(String inputText, double min, double max) {
        System.out.println(inputText);
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            value = scanner.nextInt();
            if (value >= min && value <= 1000000) {
                break;
            }
            System.out.println("Enter a value between" + min + "and" + max);
        }
        return value;
    }

    public static void main(String[] args) {
        int principal;
        principal = (int) readNumber("Principle ($1K~1M) : ", 1000, 1000000);
        float rate;
        rate = (float) readNumber("Rate : ", 1, 30);
        byte years;
        years = (byte) readNumber("Period(Years) : ", 1, 30);
        printPaymentMortgage(principal, rate, years);
        printPaymentSchedule(principal, rate, years);
    }

    private static void printPaymentMortgage(int principal, float rate, byte years) {
        double mortgage = calculatMortgage(principal, rate, years);
        String mortgageStr = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage  " + "\n" + "-----------------");
        System.out.println("Monthly Payments" + mortgageStr + "\n");
    }

    private static void printPaymentSchedule(int principal, float rate, byte years) {
        System.out.println("PAYMENT SCHEDULE" + "\n" + "-----------------");
        for (short month = 1; month < years * MONTHS_IN_YEAR; month++) {
            double balance = calculatBalance(principal, rate, years, month);
            String formatBalance = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(formatBalance);
        }
    }
}
