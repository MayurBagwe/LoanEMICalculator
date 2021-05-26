package com.test.loan;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanModule {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int TOTAL_MONTHS = 12;
        final int PERCENTAGE = 100;

        System.out.print("Principal: ");
        int principal = Integer.parseInt(scanner.nextLine());


        System.out.print("Annual Interest Rate: ");
        float annualInterest = Float.parseFloat(scanner.nextLine());


        float monthlyInterest = annualInterest / PERCENTAGE / TOTAL_MONTHS ;

        System.out.print("Period (Years): ");
        int months = Integer.parseInt(scanner.nextLine()) * TOTAL_MONTHS;


        double mortage = ((principal * monthlyInterest) * Math.pow(1+monthlyInterest,months))/ (Math.pow(1+monthlyInterest,months) - 1);
        String finalAmount = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.println("Mortgage: "+finalAmount);




    }
}
