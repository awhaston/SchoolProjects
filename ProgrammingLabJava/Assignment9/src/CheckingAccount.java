/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 9
*/

public class CheckingAccount extends BankAccount{
    double dailyWithdrawLimit;
    public CheckingAccount(String customerName, String userId, String userPw) {
        super(customerName, userId, userPw);
        dailyWithdrawLimit = 300;
    }

    public double getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }

    public void setDailyWithdrawLimit(double dailyWithdrawLimit) {
        this.dailyWithdrawLimit = dailyWithdrawLimit;
    }
}
