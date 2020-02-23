package com.wolverinesystems;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var mortgage1 = new Mortgage(principal, annualInterest, years);
        var mortgage2 = new Mortgage(principal, annualInterest, years);

        System.out.println("Number of Mortgages: " + Mortgage.numberOfMortgages);

        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println(mortgage1.printMortgage());
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        mortgage1.printBalance();
    }

}
