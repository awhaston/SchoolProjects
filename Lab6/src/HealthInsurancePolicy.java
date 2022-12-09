/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 5
*/

public class HealthInsurancePolicy extends InsurancePolicy implements Deductible{
    private double deductibleLimit;
    private double totalDeductiblePaid = 0;
    private double coPayment;
    private double totalCoPaymentPaid = 0;
    private double totalOutOfPocket;

    HealthInsurancePolicy(String policyHolder, double deductibleLimit, double coPayment, double totalOutOfPocket){
        super(policyHolder);
        this.deductibleLimit = deductibleLimit;
        this.coPayment = coPayment;
        this.totalOutOfPocket = totalOutOfPocket;

    }

    public String toString(){
        return super.toString() + ", Deductible Limit: " + this.deductibleLimit + ", Co-Payment: " + this.coPayment + ", \nTotal Out of Pocket: " + this.totalOutOfPocket
                + ", Total Deductible Paid: " + this.totalDeductiblePaid + ", Total Co-Payment Paid: " + this.totalCoPaymentPaid;
    }

    @Override
    public boolean hasMetDeductible() {
        if(totalDeductiblePaid >= deductibleLimit){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean hasMetTotalOutOfPocket() {
        if(totalDeductiblePaid + totalCoPaymentPaid >= totalOutOfPocket){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void selectPolicyCoverage() {
        System.out.println("Selecting policy coverages...");
    }

    @Override
    public void calculatePremium() {
        System.out.println("Calculating premiums...");
    }

    public double getDeductibleLimit() {
        return deductibleLimit;
    }

    public void setDeductibleLimit(double deductibleLimit) {
        this.deductibleLimit = deductibleLimit;
    }

    public double getTotalDeductiblePaid() {
        return totalDeductiblePaid;
    }

    public void setTotalDeductiblePaid(double totalDeductiblePaid) {
        this.totalDeductiblePaid = totalDeductiblePaid;
    }

    public double getCoPayment() {
        return coPayment;
    }

    public void setCoPayment(double coPayment) {
        this.coPayment = coPayment;
    }

    public double getTotalCoPaymentPaid() {
        return totalCoPaymentPaid;
    }

    public void setTotalCoPaymentPaid(double totalCoPaymentPaid) {
        this.totalCoPaymentPaid = totalCoPaymentPaid;
    }

    public double getTotalOutOfPocket() {
        return totalOutOfPocket;
    }

    public void setTotalOutOfPocket(double totalOutOfPocket) {
        this.totalOutOfPocket = totalOutOfPocket;
    }
}
