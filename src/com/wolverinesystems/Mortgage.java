package com.wolverinesystems;

import java.text.NumberFormat;

public class Mortgage {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private static int principal;
    private static float annualInterest;
    private static byte years;

    public static int numberOfMortgages;

    // INSTANTIATE Mortgage Class Object
    public Mortgage(int principal, float annualInterest, byte years){
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
        numberOfMortgages++;
    }

    // METHODS on CLASS
    public String printMortgage(){
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        return mortgageFormatted;
    }

    public void printBalance(){
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        double balance = 0;
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            balance = principal
                    * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, month))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    // SETTERS:
    private void setPrincipal(int principal) {
        if (principal <= 0){
            throw new IllegalArgumentException("Principal cannot be 0 or less.");
        }
        this.principal = principal;
    }

    private void setAnnualInterest(float annualInterest) {
        if (annualInterest <= 0){
            throw new IllegalArgumentException("Annual interest rate cannot be 0 or less.");
        }
        this.annualInterest = annualInterest;
    }

    private void setYears(byte years){
        if (years <= 0){
            throw new IllegalArgumentException("Years cannot be 0 or less.");
        }
        this.years = years;
    }

}
