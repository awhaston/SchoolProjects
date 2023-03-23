/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 5
*/

public class FibIteration implements FindFib{

    @Override
    public int calculate_fib(int i) {
        int fib_number;
        int number_x = 1;
        int number_y = 0;
        int number_z;
        if(i == 1 || i == 2){
            return number_x;
        }else{
            for(int j = 1; j < i; j++){
                number_z = number_x;
                number_x = number_x + number_y;
                number_y = number_z;
            }
        }
        return number_x;
    }
}
