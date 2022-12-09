/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 7
*/

package com.assignment7;

public class Calculator {
    private double loan_amount;
    private int number_years;
    private double interest_rate;
    private boolean is_deferred;
    private boolean is_missed;
    private boolean is_automatic;

    public Calculator(double loan_amount, int number_years, double interest_rate, boolean is_deferred, boolean is_missed, boolean is_automatic) {
        this.loan_amount = loan_amount;
        this.number_years = number_years;
        this.interest_rate = interest_rate;
        this.is_deferred = is_deferred;
        this.is_missed = is_missed;
        this.is_automatic = is_automatic;
    }

    public double calculateLoan(){

        if(this.is_deferred){
            return 0;
        } else {
            double r = this.interest_rate * 0.01;
            if(this.is_missed){
                r -= 0.0025;
            }
            if (this.is_automatic){
                r -= 0.0025;
            }
            double pv = this.loan_amount;
            double n = this.number_years * -1;

            double top  = r * pv;
            double exponent = Math.pow((r + 1), n);
            double bottom = 1 - exponent;

            return top/bottom;
        }
    }

    @Override
    public String toString() {
        return "com.assignment7.Calculator{" +
                "loan_amount=" + loan_amount +
                ", number_years=" + number_years +
                ", interest_rate=" + interest_rate +
                ", is_deferred=" + is_deferred +
                ", is_missed=" + is_missed +
                ", is_automatic=" + is_automatic +
                '}';
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public int getNumber_years() {
        return number_years;
    }

    public void setNumber_years(int number_years) {
        this.number_years = number_years;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }

    public boolean isIs_deferred() {
        return is_deferred;
    }

    public void setIs_deferred(boolean is_deferred) {
        this.is_deferred = is_deferred;
    }

    public boolean isIs_missed() {
        return is_missed;
    }

    public void setIs_missed(boolean is_missed) {
        this.is_missed = is_missed;
    }

    public boolean isIs_automatic() {
        return is_automatic;
    }

    public void setIs_automatic(boolean is_automatic) {
        this.is_automatic = is_automatic;
    }
}
