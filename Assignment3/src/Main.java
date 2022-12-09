/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 3
*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayList<Faculty> faculty = new ArrayList<Faculty>();
	    boolean quit = false;
        int choice = 0;

        do{
            Scanner scan = new Scanner(System.in);
            System.out.println(
                    "1 – Add Faculty\n" +
                    "2 – Delete Faculty\n" +
                    "3 – Calculate Faculty Pay\n" +
                    "4 – Print Faculty\n" +
                    "5 – Exit");
            try{
                choice = scan.nextInt();
            }catch (InputMismatchException a){
                System.out.println("Error Invalid Input! Please try again!");
            }
            switch(choice){
                case 1:
                    addFaculty(faculty);
                    break;
                case 2:
                    removeFaculty(faculty);
                    break;
                case 3:
                    calculateFacultyPay(faculty);
                    break;
                case 4:
                    printFaculty(faculty);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please try again!");
                    break;
            }

        }while(quit == false);
    }

    public static void addFaculty(ArrayList<Faculty> faculty){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter name of faculty member:");
        String name = scan.nextLine();
        System.out.println("Please enter weekly salary of faculty member:");
        double salary = scan.nextDouble();
        System.out.println("Please enter weekly stipend of faculty member:");
        double stipend = scan.nextDouble();
        faculty.add(new Faculty(name, salary, stipend));
    }

    public static void removeFaculty(ArrayList<Faculty> faculty){
        System.out.println("Enter Employee Name:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        for (int i = 0; i < faculty.size(); i++) {
            if(faculty.get(i).getName().equalsIgnoreCase(name)){
                faculty.remove(i);
            }
        }
    }

    public static void printFaculty(ArrayList<Faculty> faculty){
        for (Faculty value : faculty) {
            System.out.println(value.toString());
        }
    }

    public static void calculateFacultyPay(ArrayList<Faculty> faculty){
        for(Faculty value : faculty){
            value.calculatePay();
        }
    }
}
