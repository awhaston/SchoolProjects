/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 5
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    FibIteration iteration = new FibIteration();
        FibFormula formula = new FibFormula();
        System.out.println("Enter the number you want to find the Fibonacci Series for:");
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println("Fib of " + i + " by iteration: " + iteration.calculate_fib(i));
        System.out.println("Fib of " + i + " by formula: " + formula.calculate_fib(i));
    }
}
