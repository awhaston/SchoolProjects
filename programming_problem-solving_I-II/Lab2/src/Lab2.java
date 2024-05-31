/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 2
*/
import java.util.Scanner;

public class Lab2 {
    public static void main(String args[]){
        boolean quit = false;
        double p;
        int q;
        int choice;
        Scanner scan = new Scanner(System.in);

        StockItem milk = new StockItem(3.60, 15, "1 Gallon of Milk");
        StockItem bread = new StockItem(1.98, 30, "1 Loaf of Bread");

        do{
            printMenu();
            choice = scan.nextInt();

            switch(choice){
                case 1:
                    milk.lowerQuantity();
                    break;
                case 2:
                    bread.lowerQuantity();
                    break;
                case 3:
                    System.out.print("Enter new price of milk: ");
                    p = scan.nextFloat();
                    milk.setPrice(p);
                    break;
                case 4:
                    System.out.print("Enter new price of bread: ");
                    p = scan.nextFloat();
                    bread.setPrice(p);
                    break;
                case 5:
                    System.out.print("Enter quantity to add to milk: ");
                    q = scan.nextInt();
                    milk.raiseQuantity(q);
                    break;
                case 6:
                    System.out.print("Enter quantity to add to bread: ");
                    q = scan.nextInt();
                    bread.raiseQuantity(q);
                    break;
                case 7:
                    System.out.println("Milk: " + milk.toString());
                    System.out.println("Bread: " + bread.toString());
                    break;
                case 8:
                    quit = true;
                    break;
            }
        }while(quit == false);
    }

    public static void printMenu(){
        System.out.println("1. Sold One Milk");
        System.out.println("2. Sold One Bread");
        System.out.println("3. Change Price of Milk");
        System.out.println("4. Change Price of Bread");
        System.out.println("5. Add Milk to Inventory");
        System.out.println("6. Add Bread to Inventory");
        System.out.println("7. See Inventory");
        System.out.println("8. Quit");
    }
}
