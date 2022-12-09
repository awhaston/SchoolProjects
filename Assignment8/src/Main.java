
/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 8
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        boolean quit = false;
        int decimal;
        String address;
        do{
            Scanner scan = new Scanner(System.in);
            printMenu();
            choice = scan.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter decimal to convert to binary: ");
                    decimal = scan.nextInt();
                    System.out.println("Decimal Number: " + decimal);
                    System.out.println("Binary Number: " + decimal2Binary(decimal));
                    break;
                case 2:
                    System.out.print("Enter decimal to convert to hexadecimal: ");
                    decimal = scan.nextInt();

                    System.out.println("Decimal Number: " + decimal);
                    System.out.println("Hexadecimal Number: " + decimal2Hex(decimal));
                    break;
                case 3:
                    System.out.print("Enter IP address to convert to binary: ");
                    scan = new Scanner(System.in);
                    address = scan.nextLine();
                    String[] ipAddressConverted = address.split("\\.");
                    System.out.println("IP Address: " + address);
                    System.out.println("IP Address in Binary: " + convertIPAddress(ipAddressConverted, ipAddressConverted.length - 1));
                    break;
                case 4:
                    System.out.print("Enter MAC address to convert to hexadecimal: ");
                    scan = new Scanner(System.in);
                    address = scan.nextLine();
                    String[] macAddressConverted = address.split("\\:");
                    System.out.println("MAC Address: " + address);
                    System.out.println("MAC Address in Hexadecimal: " + convertMacAddress(macAddressConverted, macAddressConverted.length - 1));
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Enter valid input");
                    break;
            }
        }while(!quit);

    }

    public static String decimal2Binary(int decimal){
        if(decimal == 1){
            return "1";
        } else if (decimal % 2 != 0) {
            return  decimal2Binary(decimal / 2) + "1";

        } else{
            return decimal2Binary(decimal / 2) + "0";
        }
    }

    public static String decimal2Hex(int decimal){
        if (decimal <= 0){
            return "";
        } else if(decimal <= 1){
            return "1";
        }else if (decimal % 16 == 10){
            return decimal2Hex(decimal / 16) + "A";
        } else if (decimal % 16 == 11){
            return decimal2Hex(decimal / 16) + "B";
        } else if (decimal % 16 == 12){
            return decimal2Hex(decimal / 16) + "C";
        } else if (decimal % 16 == 13){
            return decimal2Hex(decimal / 16) + "D";
        } else if (decimal % 16 == 14){
            return decimal2Hex(decimal / 16) + "E";
        } else if (decimal % 16 == 15){
            return decimal2Hex(decimal / 16) + "F";
        } else {
            String decimalString = String.valueOf(decimal % 16);
            return decimal2Hex(decimal / 16) + decimalString;
        }
    }

    public static String convertIPAddress(String[] ip, int index){
        if (index == 0){
            return decimal2Binary(Integer.parseInt(ip[index]));
        } else {
            return   convertIPAddress(ip, index -1) + "." + decimal2Binary(Integer.parseInt(ip[index]));
        }
    }

    public static String convertMacAddress(String[] mac, int index){
        if (index == 0){
            return decimal2Hex(Integer.parseInt(mac[index]));
        } else {
            return   convertMacAddress(mac, index -1) + ":" + decimal2Hex(Integer.parseInt(mac[index]));
        }
    }

    public static void printMenu(){
        System.out.println("1 – Convert Decimal Number to Binary Number\n" +
                "2 – Convert Decimal Number to Hexadecimal Number\n" +
                "3 – Convert Decimal IP Address to Binary IP Address\n" +
                "4 – Convert Decimal MAC Address to Hexadecimal MAC Address \n" +
                "5 – Exit");
        System.out.print("Enter choice: ");
    }

}