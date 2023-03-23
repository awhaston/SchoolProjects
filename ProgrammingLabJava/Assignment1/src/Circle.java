/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 1
*/

public class Circle {
    private double radius;

    Circle(double r){
        radius = r;
    }

    public double getCircumference(){
        return 2 * Math.PI * radius;
    }

    public double getArea(){
        return Math.PI * (Math.pow(radius, 2));
    }
}
