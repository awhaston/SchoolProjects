public class Account {
    private int accountNumber;
    private double accountBalance;
    private static int id = 10001;

    public Account(){
        accountBalance = 0;
        accountNumber = id;
        id++;
    }

    public Account(int balance){
        accountBalance = balance;
        accountNumber = id;
        id++;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public void depositMoney(double deposit){
        accountBalance += deposit;
    }

    public void withdrawMoney(double withdraw){
        accountBalance -= withdraw;
    }

}
