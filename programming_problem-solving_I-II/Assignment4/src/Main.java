/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 4
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        ArrayList<Loan> loans = new ArrayList<>();
        do{
            System.out.println(
                    "1 – Add Loan\n" +
                    "2 – Delete Loan\n" +
                    "3 – Calculate Monthly Payments \n" + "4 – Print Loans\n" +
                    "5 – Exit\n");

            System.out.print("Enter Choice: ");

            Scanner scan = new Scanner(System.in);

            try {
                choice = scan.nextInt();
            }catch (Exception a){}

            switch(choice){
                case 1:
                    addLoan(loans);
                    break;
                case 2:
                    deleteLoan(loans);
                    break;
                case 3:
                    calculateMonthlyPayment(loans);
                    break;
                case 4:
                    printLoan(loans);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input! Please try again!");
                    break;
            }
        }while(quit == false);
    }

    public static void addLoan(ArrayList<Loan> loans){
        Scanner scan = new Scanner(System.in);
        String d = null;
        boolean deferred = false;
        System.out.println("Enter loan type 1 - Student 2 - Auto");
        int choice = scan.nextInt();
        while(choice != 1 && choice != 2){
            System.out.println("Invalid choice please try again!");
            choice = scan.nextInt();
        }

        System.out.println("Enter customer name:");
        scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Enter loan amount:");
        double loan = scan.nextDouble();
        System.out.println("Enter interest rate:");
        double rate = scan.nextDouble();
        System.out.println("Enter monthly payments:");
        int months = scan.nextInt();

        if(choice == 1){
            System.out.println("Is the loan deferred y or n:");
            do {
                scan = new Scanner(System.in);
                d = scan.nextLine();
                if (d.equalsIgnoreCase("y")) {
                    deferred = true;
                } else if (d.equalsIgnoreCase("n")) {
                    deferred = false;
                }else{
                    System.out.println("Invalid input! Please try again!");
                }
            }while(!d.equalsIgnoreCase("y") && !d.equalsIgnoreCase("n"));
            loans.add(new StudentLoan(name, loan, rate, months, deferred));
        }else if(choice == 2){
            System.out.println("Enter down payment:");
            double down = scan.nextDouble();
            loans.add(new AutoLoan(name, loan, rate, months, down));
        }
    }

    public static void deleteLoan(ArrayList<Loan> loans){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of customer to delete loan");
        String choice = scan.nextLine();
        for(int i = 0; i < loans.size(); i++){
            if(loans.get(i).getCustomerName().equalsIgnoreCase(choice)){
                loans.remove(i);
            }
        }

    }

    public static void calculateMonthlyPayment(ArrayList<Loan> loans){
        for(int i = 0; i < loans.size(); i++){
            loans.get(i).calculateMonthlyPayment();
        }
    }

    public static void printLoan(ArrayList<Loan> loans){
        for(int i = 0; i < loans.size(); i++){
            System.out.println(loans.get(i).toString());
        }
    }
}
