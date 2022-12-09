/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 4
*/

public class Loan {
    private String customerName;
    private int accountNumber;
    private double loanAmount;
    private double monthlyPayment;
    private double interestRate;
    private int numberOfMonthlyPayments;
    private static int numberOfLoans = 0;

    Loan(String name, double amount, double rate, int months){
        ++numberOfLoans;
        accountNumber = numberOfLoans;
        customerName = name;
        loanAmount = amount;
        interestRate = rate;
        numberOfMonthlyPayments = months;
    }

    Loan(){
        numberOfLoans++;
    }

    public static int getNumberOfLoans(){
        return numberOfLoans;
    }

    public static void decreaseNumberOfLoans(){
        numberOfLoans--;
    }

    public void calculateMonthlyPayment(){
        double r = this.interestRate * 0.01;
        double pv = this.loanAmount;
        double n = this.numberOfMonthlyPayments * -1;
        double top  = r * pv;
        double exponent = Math.pow((r + 1), n);
        double bottom = 1 - exponent;

        monthlyPayment = top/bottom;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getNumberOfMonthlyPayments() {
        return numberOfMonthlyPayments;
    }

    public void setNumberOfMonthlyPayments(int numberOfMonthlyPayments) {
        this.numberOfMonthlyPayments = numberOfMonthlyPayments;
    }

    public String toString(){
        return "Customer name: " + this.customerName + " Account Number " + this.accountNumber + " Balance: " + this.loanAmount + " Rate: "
                + this.interestRate + " Number of Months: " + this.numberOfMonthlyPayments + " Monthly Payment: " + this.monthlyPayment;
    }
}
