/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 5
*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String choice = null;
        Item[] items = new Item[5];

        for(int i = 0; i < 5; i++) {
            System.out.println("Please enter \"B\" for Book or \"P\" for Periodical");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();

            while(!choice.equalsIgnoreCase("p") && !choice.equalsIgnoreCase("b")){
                System.out.println("Invalid input please try again");
                choice = scan.nextLine();
            }

            if(choice.equalsIgnoreCase("b")){
                scan = new Scanner(System.in);
                System.out.println("Please enter the Title:");
                String title = scan.nextLine();
                System.out.println("Please enter the Author:");
                String author = scan.nextLine();
                System.out.println("Please enter the ISBN Number:");
                int isbn = scan.nextInt();

                items[i] = new Book(isbn, author, title);
            }
            else if(choice.equalsIgnoreCase("p")){
                scan = new Scanner(System.in);
                System.out.println("Please enter the Title:");
                String title = scan.nextLine();
                System.out.println("Please enter the Issue Number:");
                int issueNum = scan.nextInt();

                items[i] = new Periodical(issueNum, title);
            }
        }

        System.out.print("Your items:\n");
        for(int i = 0; i < items.length; i++){
            System.out.println(items[i].getListing() + "\n");
        }
    }
}
