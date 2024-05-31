/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 1
*/

public class Rectangle {
    private double height;
    private double width;

    Rectangle(double h, double w){
        height = h;
        width = w;
    }

    public double getPerimeter(){
        return 2*height + 2*width;
    }

    public double getArea(){
        return height * width;
    }
}
