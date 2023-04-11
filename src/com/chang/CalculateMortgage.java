package com.chang;

import java.text.NumberFormat;
import java.util.Scanner;

public class CalculateMortgage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;
        int principle = 0;
        double rate = 0;
        int period=0;
        System.out.print("Principle ($1K~1M) : ");
        while (true) {
            principle = scanner.nextInt();
            if (principle >= 1000 && principle <= 1000000) {
                break;
            }
            System.out.println("Enter a value between 1000 and 1000000");
        }
        System.out.print("Rate : ");
        while (true) {
            double annualInterestRate = scanner.nextDouble();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                rate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        System.out.print("Period(Years) : ");
        while (true) {
            period = scanner.nextInt();
            if (period >= 1 && period <= 30) {
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double pow = Math.pow((1 + rate), period * MONTHS_IN_YEAR);
        double result = principle * ((rate * pow) / (pow - 1));
        String mortgage = NumberFormat.getCurrencyInstance().format(result);
        System.out.println("Mortgage  "+"\n"+"-----------------");
        System.out.println("Monthly Payments"+ mortgage+"\n");
        System.out.println("PAYMENT SCHEDULE"+"\n"+"-----------------");

    }

}
