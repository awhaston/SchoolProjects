/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 7
*/

public class Calculator implements CalcOp{
    @Override
    public float add(float x, float y) {
        return x + y;
    }

    @Override
    public float sub(float x, float y) {
        return x - y;
    }

    @Override
    public float multiply(float x, float y) {
        return x * y;
    }

    @Override
    public float divide(float x, float y) {
        return x / y;
    }
}
