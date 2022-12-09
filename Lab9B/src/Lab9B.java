/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 9a
*/

import java.util.Scanner;

public class Lab9B {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(printNTimes("I will study recursion until it makes sense\n", 100));
        System.out.println("Enter the first String:");
        String a = scan.nextLine();
        System.out.println("Enter the second String:");
        String b = scan.nextLine();
        if(isReverse(a, b)){
            System.out.println(a + " is the reverse of " + b);
        } else {
            System.out.println(a + " is not the reverse of " + b);
        }

    }

    public static String printNTimes(String string, int times){
        if (times == 0){
            return "";
        }
        return string + printNTimes(string, times - 1);
    }

    public static boolean isReverse(String a, String b){
        String charA = "", charB = "";
        int j = b.length() - 1;
        if (a.equals("") && b.equals("")) return true;
        else if (a.length() == 1 && b.length() == 1){
            if (a.equals(b)){
                return true;
            } else {
                return false;
            }
        } else if (a.length() != b.length()){
            return false;
        } else {
            for (int i = 0; i < a.length(); i++) {
                charA = String.valueOf(a.charAt(i));
                charB = String.valueOf(b.charAt(j));
                boolean isReverse = isReverse(charA, charB);
                if (!isReverse){
                    return false;
                }
                j--;
            }
            return true;
        }
    }
}
