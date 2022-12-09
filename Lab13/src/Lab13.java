/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 13
*/

import java.util.Scanner;

public class Lab13 {
    public static void main(String[] args) {
        boolean quit = false;
        BlueRayCollection collection = new BlueRayCollection();
        collection.showAll();
        do{
            Scanner scan = new Scanner(System.in);
            printMenu();
            int choice = scan.nextInt();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    addBlueray(collection);
                    break;
                case 2:
                    collection.showAll();
                    break;
            }
        }while(quit == false);
    }

    public static void printMenu(){
        System.out.println("0. Quit\n" +
                "1. Add BlueRay to collection\n" +
                "2. See collection");
    }

    public static void addBlueray(BlueRayCollection collection){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter movie title: ");
        String title = scan.nextLine();
        System.out.print("Enter movie director: ");
        String director = scan.nextLine();
        System.out.print("Enter the release year: ");
        scan = new Scanner(System.in);
        int year = scan.nextInt();
        System.out.print("Enter cost of movie: ");
        double cost = scan.nextDouble();
        collection.add(title, director, year, cost);
    }
}
