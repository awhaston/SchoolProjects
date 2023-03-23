public class Checking extends Account{

    public Checking(double balance){
        this.setAccountBalance(balance);
    }

    public Checking() {

    }

    @Override
    public void withdrawMoney(double withdraw) {
        double balance = this.getAccountBalance();
        double newBalance;
        if(this.getAccountBalance()-withdraw < 0){
            System.out.println("Charging an overdraft fee of $20 because account is below $0");
            newBalance = (this.getAccountBalance() - withdraw) - 20;
        }else{
            newBalance = this.getAccountBalance() - withdraw;
        }
        this.setAccountBalance(newBalance);
    }
}
