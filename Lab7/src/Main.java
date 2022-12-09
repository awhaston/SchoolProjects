/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 7
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        boolean quit = false;
        int choice;

        do{
            choice = printMenu();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println(calculator.add(firstNumber(), secondNumber()));
                    break;
                case 2:
                    System.out.println(calculator.sub(firstNumber(), secondNumber()));
                    break;
                case 3:
                    System.out.println(calculator.multiply(firstNumber(), secondNumber()));
                    break;
                case 4:
                    System.out.println(calculator.divide(firstNumber(), secondNumber()));
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }

        }while(quit == false);
    }

    public static float firstNumber(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        float x = scan.nextFloat();
        return x;
    }
    public static float secondNumber(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the second number: ");
        float y = scan.nextFloat();
        return y;
    }
    public static int printMenu(){
        System.out.println("0 - Exit\n" +
                "1 - Addition\n" +
                "2 - Subtraction\n" +
                "3 - Multiplication \n" +
                "4 - Division");
        System.out.print("Please Choose an Option: ");

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        return choice;
    }
}
