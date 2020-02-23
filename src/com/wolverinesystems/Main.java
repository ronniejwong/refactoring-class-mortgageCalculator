package com.wolverinesystems;

import com.sun.source.doctree.SystemPropertyTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int principal = (int)readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float)readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte)readNumber("Period (Years): ", 1, 30);

        var mortgage1 = new Mortgage(principal, annualInterest, years);

        System.out.println("Number of Mortgages: " + Mortgage.numberOfMortgages);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println(mortgage1.printMortgage());
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        mortgage1.printBalance();
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true){
            System.out.println(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
}
