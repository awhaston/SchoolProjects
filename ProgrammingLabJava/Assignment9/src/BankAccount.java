/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 8
*/

public class BankAccount {
    private String customerName;
    private int accountNumber;
    private String userId;
    private String userPw;
    private double accountBalance;
    private static int numberOfAccounts = 0;

    public BankAccount(String customerName, String userId, String userPw) {
        this.customerName = customerName;
        this.accountNumber = numberOfAccounts;
        this.userId = userId;
        this.userPw = userPw;
        numberOfAccounts++;
    }

    @Override
    public String toString() {
        return "customerName=" + customerName +
                ", accountNumber=" + accountNumber   +
                ", accountBalance=" + accountBalance;
    }

    public void depositAmount (double amount){
        this.accountBalance += amount;
    }

    public void withdrawAmount (double amount){
        this.accountBalance -= amount;
    }

    public static void decreaseNumberOfAccounts(){
        numberOfAccounts--;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }
}
