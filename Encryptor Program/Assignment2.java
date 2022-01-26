/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 2
*/

import java.util.Scanner;

public class Assignment2 {
    public static void main(String args[]){
        int choice;
        boolean quit = false;
        String message;
        Scanner scan = new Scanner(System.in);
        Encryption encrypt = new Encryption();
        do{
        System.out.println(
                "1 Encrypt a message\n" +
                "2 Decrypt a message\n" +
                "3 Quit\n" +
                "Enter Choice");
        choice = scan.nextInt();

        switch(choice) {
            case 1:
                System.out.println("Please enter a message:");
                scan = new Scanner(System.in);
                message = scan.nextLine();
                System.out.println(encrypt.encrypt_message(message));
                break;
            case 2:
                System.out.println("Please enter a message:");
                scan = new Scanner(System.in);
                message = scan.nextLine();
                System.out.println(encrypt.decrypt_message(message));
                break;
            case 3:
                quit = true;
                break;
            default:
                System.out.println("Please enter a valid input");
                break;
        }
        }while(quit == false);
    }
}
