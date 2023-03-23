/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 4
*/

public class StudentLoan extends Loan{
    private boolean isDeferred;

    StudentLoan(String name, double amount, double rate, int months, boolean isDef){
        super(name, amount, rate, months);
        this.isDeferred = isDef;
    }

    public boolean isDeferred() {
        return isDeferred;
    }

    public void setDeferred(boolean deferred) {
        isDeferred = deferred;
    }

    public void calculateMonthlyPayment(){
        double r = this.getInterestRate() * 0.01;
        double pv = this.getLoanAmount();
        double n = this.getNumberOfMonthlyPayments() * -1;


        double top  = r * pv;
        double exponent = Math.pow((r + 1), n);
        double bottom = 1 - exponent;

        if(isDeferred){
            this.setMonthlyPayment(0);
        }else{
            this.setMonthlyPayment(top / bottom);
        }
    }

    public String toString(){
        return super.toString() + " Deferred: " + this.isDeferred;
    }
}
