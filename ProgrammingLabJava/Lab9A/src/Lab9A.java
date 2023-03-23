/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 9A
*/

import java.util.Scanner;

public class Lab9A {

    public static void main(String[] args) {
        boolean quit = false;
        int x;
        int y;
        int choice;
        System.out.println(recursive_multiply(5, 3));
        do{
            print_menu();
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter number 1:");
                    scan = new Scanner(System.in);
                    x = scan.nextInt();
                    System.out.println("Enter number 2:");
                    y = scan.nextInt();
                    System.out.println(recursive_multiply(x, y));
                    break;
                case 2:
                    System.out.println("Enter number 1:");
                    scan = new Scanner(System.in);
                    x = scan.nextInt();
                    System.out.println("Enter number 2:");
                    y = scan.nextInt();
                    System.out.println(recursive_div(x, y));
                    break;
                case 3:
                    System.out.println("Enter number 1:");
                    scan = new Scanner(System.in);
                    x = scan.nextInt();
                    System.out.println("Enter number 2:");
                    y = scan.nextInt();
                    System.out.println(recursive_mod(x, y));
                    break;
            }
        }while(!quit);
    }

    public static int recursive_multiply(int x, int y){
        if (y == 0){
            return 0;
        }else {
            return x + recursive_multiply(x,y - 1);
        }
    }

    public static int recursive_div(int x, int y){
        if (y == 0){
            return -1;
        }else if (x == y){
            return 1;
        } else if (x < y){
            return 0;
        } else {
            return 1 + recursive_div(x-y, y);
        }
    }

    public static int recursive_mod(int x, int y){
        if (y == 0) {
            return -1;
        } else if (x < y){
            return x;
        } else {
            return recursive_mod(x - y, y);
        }
    }

    public static void print_menu(){
        System.out.println("Choose from the following:\n" +
                "0.  Quit\n" +
                "1.  Multiply 2 numbers\n" +
                "2.  Div 2 numbers\n" +
                "3.  Mod 2 numbers");
    }

}
