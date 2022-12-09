/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 12
*/

import java.util.Scanner;

public class Assignment12 {
    public static void main(String[] args) {
        int choice = -1;
        boolean quit = false;
        Scanner scan;
        JobLeadList list = new JobLeadList();
        String companyName, contactName, contactPhone, jobTitle, jobDescription;
        do{
            printMenu();
            scan = new Scanner(System.in);
            choice = scan.nextInt();

            switch(choice){
                case 1:
                    scan = new Scanner(System.in);
                    System.out.println("Enter company name:");
                    companyName = scan.nextLine();
                    System.out.println("Enter contact name: ");
                    contactName = scan.nextLine();
                    System.out.println("Enter contact phone: ");
                    contactPhone = scan.nextLine();
                    System.out.println("Enter job title: ");
                    jobTitle = scan.nextLine();
                    System.out.println("Enter job description: ");
                    jobDescription = scan.nextLine();
                    list.addToFront(companyName, contactName, contactPhone, jobTitle, jobDescription);
                    break;
                case 2:
                    scan = new Scanner(System.in);
                    System.out.println("Enter company name:");
                    companyName = scan.nextLine();
                    System.out.println("Enter contact name: ");
                    contactName = scan.nextLine();
                    System.out.println("Enter contact phone: ");
                    contactPhone = scan.nextLine();
                    System.out.println("Enter job title: ");
                    jobTitle = scan.nextLine();
                    System.out.println("Enter job description: ");
                    jobDescription = scan.nextLine();
                    list.addToTail(companyName, contactName, contactPhone, jobTitle, jobDescription);
                    break;
                case 3:
                    scan = new Scanner(System.in);
                    System.out.println("Enter company name:");
                    String tempCompanyName = scan.nextLine();
                    System.out.println("Enter job title:");
                    String tempJobTitle = scan.nextLine();
                    list.removeLead(tempCompanyName, tempJobTitle);
                    break;
                case 4:
                    list.printHeadToTail();
                    break;
                case 5:
                    list.printTailToHead();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Enter valid input!");
                    break;
            }

        }while(!quit);


    }

    public static void printMenu(){
        System.out.println("""
                1 – Add lead to head of list
                2 – Add lead to tail of list
                3 – Delete a lead
                4 – Print list from head to tail
                5 – Print list from tail to head
                6 – Exit""");
        System.out.print("Enter choice: ");
    }
}
