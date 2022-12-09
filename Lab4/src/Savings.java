public class Savings extends Account{
    private int deposits;

    public Savings(double balance){
        this.setAccountBalance(balance);
        deposits = 0;
    }

    public Savings(){
        deposits = 0;
    }

    public void addInterest(){
        double balance = this.getAccountBalance();
        double newBalance;
        double interestGained = balance * .015;
        System.out.println("Customer earned $" + interestGained + " in interest");
        newBalance = balance + interestGained;
        this.setAccountBalance(newBalance);
    }

    @Override
    public void withdrawMoney(double withdraw) {
        double balance = this.getAccountBalance();
        double newBalance;
        if(this.getAccountBalance()-withdraw < 500){
            System.out.println("Charging an overdraft fee of $10 because account is below $500");
            newBalance = (this.getAccountBalance() - withdraw) - 10;
        }else{
            newBalance = this.getAccountBalance() - withdraw;
        }
        this.setAccountBalance(newBalance);
    }


    public void depositMoney(double deposit){
        deposits++;
        double balance = getAccountBalance();
        double newBalance;
        if (deposits <= 5) {
            System.out.println("This is deposit " + deposits);
            newBalance = balance + deposit;
        } else {
            System.out.println("This is deposit " + deposits + ". Charging a $10 fee");
            newBalance = (balance + deposit) - 10;
        }
        this.setAccountBalance(newBalance);

    }
}
