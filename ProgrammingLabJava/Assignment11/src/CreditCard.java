/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 11
*/

public class CreditCard {
    private double balance;
    CreditCard(){
        this.balance = 5000;
    }

    public double getBalance(){
        return this.balance;
    }

    public void makeWithdrawl(double amount){
        this.balance -= amount;
    }
}
