/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 5
*/

public class TermLifeInsurancePolicy extends InsurancePolicy{
    private String beneficiary;
    private int numberOfYears;
    private double termPayout;


    TermLifeInsurancePolicy(String policyHolder, String beneficiary, int years, double termPayout) {
        super(policyHolder);
        this.beneficiary = beneficiary;
        this.numberOfYears = years;
        this.termPayout = termPayout;
    }

    public String toString(){
        return super.toString() + ", Beneficiary: " + beneficiary + ", Number of Years: "  + numberOfYears + ", Term Payout: " + termPayout;
    }

    @Override
    public void selectPolicyCoverage() {
        System.out.println("Selecting policy coverages...");
    }

    @Override
    public void calculatePremium() {
        System.out.println("Calculating and updating premium...");
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getTermPayout() {
        return termPayout;
    }

    public void setTermPayout(double termPayout) {
        this.termPayout = termPayout;
    }
}
