/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 5
*/

public class FibFormula implements FindFib{
    @Override
    public int calculate_fib(int i) {
        double y = i;
        double x = Math.sqrt(5);
        double equation_one = (1 + x)/2;
        double power_one = Math.pow(equation_one, y);
        double equation_two = (1-x)/2;
        double power_two = Math.pow(equation_two, y);
        int final_fib = (int) ((power_one - power_two) / x);
        return final_fib;
    }
}
