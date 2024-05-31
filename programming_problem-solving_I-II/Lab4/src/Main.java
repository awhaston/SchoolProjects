/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 4
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    boolean quit = false;
        int choice = 0;
        double amount;
        Checking checking = new Checking();
        Savings savings = new Savings();

        do{
            System.out.println(
                    "1. Withdraw from Checking\n" +
                    "2. Withdraw from Savings\n" +
                    "3. Deposit to Checking\n" +
                    "4. Deposit to Savings\n" +
                    "5. Balance of Checking\n" +
                    "6. Balance of Savings\n" +
                    "7. Award Interest to Savings now\n" +
                    "8. Quit");
            Scanner scan = new Scanner(System.in);
            try {
                choice = scan.nextInt();
            } catch(InputMismatchException a) {
                System.out.println("Error Invalid Input Type. Try Again");
            }

            switch(choice){
                case 1:
                    System.out.println("Enter number to withdraw from checking.");
                    try{
                        amount = scan.nextDouble();
                        checking.withdrawMoney(amount);
                    } catch (InputMismatchException a) {
                        System.out.println("Invalid Input Type. Try Again");
                    }
                    break;
                case 2:
                    System.out.println("Enter number to withdraw from savings.");
                    try{
                        amount = scan.nextDouble();
                        savings.withdrawMoney(amount);
                    } catch (InputMismatchException a) {
                        System.out.println("Invalid Input Type. Try Again");
                    }
                    break;
                case 3:
                    System.out.println("Enter number to deposit to checking account.");
                    try{
                        amount = scan.nextDouble();
                        checking.depositMoney(amount);
                    } catch (InputMismatchException a) {
                        System.out.println("Invalid Input Type. Try Again");
                    }
                    break;
                case 4:
                    System.out.println("Enter number to deposit to savings account.");
                    try{
                        amount = scan.nextDouble();
                        savings.depositMoney(amount);
                    } catch (InputMismatchException a) {
                        System.out.println("Invalid Input Type. Try Again");
                    }
                    break;
                case 5:
                    System.out.println("The balance for checking " + checking.getAccountNumber()
                    + " is " + checking.getAccountBalance());
                    break;
                case 6:
                    System.out.println("The balance for savings " + savings.getAccountNumber()
                            + " is " + savings.getAccountBalance());
                    break;
                case 7:
                    savings.addInterest();
                    break;
                case 8:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try Again");
                    break;
            }


        }while(quit == false);

    }
}
