/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 4
*/

public class AutoLoan extends Loan{
    private double downPayment;

    AutoLoan(String name, double amount, double rate, int months, double down){
        super(name, amount, rate, months);
        this.downPayment = down;
    }

    public double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public void calculateMonthlyPayment(){
        double r = this.getInterestRate() * 0.01;
        double pv = this.getLoanAmount();
        double n = this.getNumberOfMonthlyPayments() * -1;


        double top  = r * (pv - this.downPayment);
        double exponent = Math.pow((r + 1), n);
        double bottom = 1 - exponent;

        this.setMonthlyPayment(top / bottom);
    }

    public String toString(){
        return super.toString() + " Down Payment: " + this.downPayment;
    }
}
