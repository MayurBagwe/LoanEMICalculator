package com.test.loan;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanModule {
    final static int TOTAL_MONTHS = 12;
    final static int PERCENTAGE = 100;

    public static void main(String[] args) {
        System.out.println("EMI Calcualtor ");

        double principal =  readNumber("Principal: ",10000,1000000);
        float annualInterest =  (float) readNumber("Annual Interest Rate: ",0,10);
        byte years = (byte) readNumber("Period (Years): ",0,30);
        System.out.println("Monthly Payments: "+ calculateMortgage(principal,annualInterest,years));

        paymentSchedule(principal,years,annualInterest);

    }

    private static void paymentSchedule(double principal, byte years, float annualInterest) {
        System.out.println();
        System.out.println("----------------");
        System.out.println();
        System.out.println("Payment Schedule");
        System.out.println();
        System.out.println("----------------");
        System.out.println();


        int months = calculateTotalMonths(years);
        float interest = calculateMonthlyInterest(annualInterest);
        System.out.println("|  Month   |   Amount Balance");
        NumberFormat.getNumberInstance().setMinimumIntegerDigits(2);
        for(int month =1;month <= months;month++){
            double  balance = principal * ( Math.pow(1+interest,months) - Math.pow(1+interest,month))/(Math.pow(1+interest,months) -1);
            System.out.println("|      "+month + "   |   "+NumberFormat.getCurrencyInstance().format(Math.round(balance)));
        }
    }



    public  static  double readNumber(String prompt,double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt);
            value = scanner.nextFloat();
            if(value > min && value < max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);

        }
        return value;
    }

    public static String calculateMortgage(double principal,float annualInterest,byte years ){
        System.out.println("MORGAGE");
        System.out.println("-------");
        float interest = calculateMonthlyInterest(annualInterest);
        int months = calculateTotalMonths(years);
        double mortgage = (principal * interest * Math.pow(1+interest,months))/(Math.pow(1+interest,months) - 1);

        return NumberFormat.getCurrencyInstance().format(Math.round(mortgage));
    }

    public static float calculateMonthlyInterest(float annualInterest){
        return annualInterest / PERCENTAGE / TOTAL_MONTHS;
    }

    public static int calculateTotalMonths(byte years){
        return years * TOTAL_MONTHS;
    }
}
