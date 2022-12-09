/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 5
*/

public abstract class InsurancePolicy {
    private String policyHolder;
    private int policyNumber;
    private static int numberOfPolicies = 0;
    private double premium = 0;

    InsurancePolicy(String policyHolder){
        numberOfPolicies++;
        this.policyNumber = numberOfPolicies;
        this.policyHolder = policyHolder;
    }

    public abstract void selectPolicyCoverage();
    public abstract void calculatePremium();

    public String toString(){
        return "Policy holder: " + this.policyHolder + ", Policy ID " + this.policyNumber + ", Premium: " + this.premium;
    }

    public static int getNumberOfPolicies() {
        return numberOfPolicies;
    }

    public static void setNumberOfPolicies(int numberOfPolicies) {
        InsurancePolicy.numberOfPolicies = numberOfPolicies;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }
}
