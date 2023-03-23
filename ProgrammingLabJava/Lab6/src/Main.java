/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 5
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<InsurancePolicy> policies = new ArrayList<>();
        boolean quit = false;

        do {
            System.out.println(
                    "1 – Create Health Insurance Policy\n" +
                    "2 – Create Term-Life Insurance Policy " +
                    "\n3 – Exit");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch(choice){
                case 1:
                    createHealthInsurance(policies);
                    break;
                case 2:
                    createLifeInsurance(policies);
                    break;
                case 3:
                    for (int i = 0; i < policies.size(); i++) {
                        if(policies.get(i) instanceof HealthInsurancePolicy){
                            System.out.println(policies.get(i).getPolicyHolder() + " " + policies.get(i).getPolicyNumber() + " Met Deductible: " + ((HealthInsurancePolicy) policies.get(i)).hasMetDeductible()
                            + " Met Total Out of Pocket: " + ((HealthInsurancePolicy) policies.get(i)).hasMetTotalOutOfPocket());
                        }else if(policies.get(i) instanceof  TermLifeInsurancePolicy){
                            System.out.println(policies.get(i).getPolicyHolder() + " " + policies.get(i).getPolicyNumber());
                        }

                    }
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input! Please try again");
                    break;
            }
        }while(quit == false);
    }

    public static void createHealthInsurance(ArrayList<InsurancePolicy> policies){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter policyholder's name:");
        String policyholder = scan.nextLine();
        System.out.println("Enter deductible amount:");
        double deductible = scan.nextDouble();
        System.out.println("Enter co-payment amount:");
        double coPayment = scan.nextDouble();
        System.out.println("Enter total out-of-pocket amount:");
        double outOfPocket = scan.nextDouble();

        policies.add(new HealthInsurancePolicy(policyholder, deductible, coPayment, outOfPocket));
    }

    public static void createLifeInsurance(ArrayList<InsurancePolicy> policies){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter policyholder's name:");
        String policyholder = scan.nextLine();
        System.out.println("Enter name of beneficiary:");
        String beneficiary = scan.nextLine();
        System.out.println("Enter numbers of years in term:");
        int years = scan.nextInt();
        System.out.println("Enter amount of payout:");
        double payout = scan.nextDouble();

        policies.add(new TermLifeInsurancePolicy(policyholder, beneficiary, years, payout));
    }
}
