/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 9
*/

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Assignment9 {
    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        ArrayList<BankAccount> accounts = new ArrayList<>();

        do{
            printMenu();
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();

            switch(choice){
                case 1:
                    createAccount(accounts);
                    break;
                case 2:
                    deleteAccount(accounts);
                    break;
                case 3:
                    depositMoney(accounts);
                    break;
                case 4:
                    withdrawMoney(accounts);
                    break;
                case 5:
                    showBalance(accounts);
                    break;
                case 6:
                    quit = true;
                    break;

            }

        }while (!quit);
    }

    public static void createAccount(ArrayList<BankAccount> accounts){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter customer name:");
        String name = scan.nextLine();
        System.out.println("Enter user id:");
        String id = scan.nextLine();
        System.out.println("Enter user password (Must have 8 characters and contain *):");
        String password = scan.nextLine();
        try {
            if (password.length() < 8 || !password.contains("*")) {
                throw new InvalidFormatException("Invalid password");
            }
        } catch (Exception e) {
                System.out.println("Invalid password please try again");
                return;
        }
        accounts.add(new CheckingAccount(name, id, password));
    }

    public static void deleteAccount(ArrayList<BankAccount> accounts){
        for(int i = 0; i < accounts.size(); i++){
            System.out.println(i + " " + accounts.get(i).getCustomerName());
        }
        System.out.println("Enter customer name to delete");
        Scanner scan = new Scanner(System.in);
        String name;
        try{
            name = scan.nextLine();
            for(int i = 0; i < accounts.size(); i++){
                if(Objects.equals(name, accounts.get(i).getCustomerName())){
                    accounts.remove(i);
                }else{
                    throw new CustomerAccountNotFoundException("Account not found");
                }
            }
            if(accounts.size() == 0) {
                throw new CustomerAccountNotFoundException("No Accounts");
            }

        } catch(Exception e){
            System.out.println("Account name not found");
            return;
        }
    }

    public static void depositMoney(ArrayList<BankAccount> accounts){
        Scanner scan = new Scanner(System.in);
        String username;
        String password;
        int index = -1;
        try{
            System.out.println("Enter user id:");
            username = scan.nextLine();
            System.out.println("Enter password:");
            password = scan.nextLine();
            for(int i = 0; i < accounts.size(); i++)
            if(Objects.equals(username, accounts.get(i).getUserId())){
                if(Objects.equals(password, accounts.get(i).getUserPw())){
                    index = i;
                } else {
                    throw new CustomerAccountNotFoundException("Invalid password");
                }
            }else{
                throw new CustomerAccountNotFoundException("Invalid username");
            }
        }catch (Exception e){
            System.out.println("Invalid username or password");
            return;
        }
        try{
            System.out.println("Enter amount to deposit");
            scan = new Scanner(System.in);
            double deposit = scan.nextInt();
            if(deposit < 0){
                throw new NegativeDollarAmountExecption("Number must be positive");
            } else {
                accounts.get(index).depositAmount(deposit);
            }
        } catch (Exception e){
            System.out.println("Number must be positive");
        }
    }

    public static void withdrawMoney(ArrayList<BankAccount> accounts){
        Scanner scan = new Scanner(System.in);
        String username;
        String password;
        int index = -1;
        try{
            System.out.println("Enter user id:");
            username = scan.nextLine();
            System.out.println("Enter password:");
            password = scan.nextLine();
            for(int i = 0; i < accounts.size(); i++)
                if(Objects.equals(username, accounts.get(i).getUserId())){
                    if(Objects.equals(password, accounts.get(i).getUserPw())){
                        index = i;
                    } else {
                        throw new CustomerAccountNotFoundException("Invalid password");
                    }
                }else{
                    throw new CustomerAccountNotFoundException("Invalid username");
                }
        }catch (Exception e){
            System.out.println("Invalid username or password");
            return;
        }
        System.out.println("Enter amount to withdraw");
        scan = new Scanner(System.in);
        double withdraw;
        try{
            withdraw = scan.nextDouble();
            if(withdraw < 0){
                throw new NegativeDollarAmountExecption("Number must be positive");
            }
        } catch (Exception e){
            System.out.println("Invalid money amount");
            return;
        }
        try{
            if (accounts.get(index).getAccountBalance() < withdraw){
                throw new InsufficientFundsException("Insufficient Funds");
            }
        } catch (Exception e){
            System.out.println("Insufficient Funds");
            return;
        }
        accounts.get(index).withdrawAmount(withdraw);
    }

    public static void showBalance(ArrayList<BankAccount> accounts){
        Scanner scan = new Scanner(System.in);
        String username;
        String password;
        int index = -1;
        try{
            System.out.println("Enter user id:");
            username = scan.nextLine();
            System.out.println("Enter password:");
            password = scan.nextLine();
            for(int i = 0; i < accounts.size(); i++)
                if(Objects.equals(username, accounts.get(i).getUserId())){
                    if(Objects.equals(password, accounts.get(i).getUserPw())){
                        if(accounts.get(i) instanceof CheckingAccount){
                            System.out.println(accounts.get(i).toString());
                            System.out.println("Account type: checking\nDaily withdraw limit "+((CheckingAccount) accounts.get(i)).getDailyWithdrawLimit() );
                        } else {
                            System.out.println(accounts.get(i).toString());
                        }
                    } else {
                        throw new CustomerAccountNotFoundException("Invalid password");
                    }
                }else{
                    throw new CustomerAccountNotFoundException("Invalid username");
                }
        } catch (Exception e){
            System.out.println("Account cannot be found");
            return;
        }
    }

    public static void printMenu(){
        System.out.println("1 – Create An Account\n" +
                "2 – Delete An Account\n" +
                "3 – Make An Account Deposit\n" +
                "4 – Make An Account Withdrawal\n" +
                "5 – Check An Account Balance\n" +
                "6 – Exit");
    }
}
